package com.springboot.spring_boot_blog_app.service.impl;

import com.springboot.spring_boot_blog_app.entity.Category;
import com.springboot.spring_boot_blog_app.entity.Post;
import com.springboot.spring_boot_blog_app.exception.ResourceNotFoundException;
import com.springboot.spring_boot_blog_app.payload.PostDto;
import com.springboot.spring_boot_blog_app.payload.PostResponse;
import com.springboot.spring_boot_blog_app.repository.CategoryRepository;
import com.springboot.spring_boot_blog_app.repository.PostRepository;
import com.springboot.spring_boot_blog_app.service.PostService;
import org.hibernate.Hibernate;
import org.hibernate.collection.spi.PersistentSet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper mapper;
    private CategoryRepository categoryRepository;


    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper mapper,CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    this.categoryRepository=categoryRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       Category category=categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(()->new ResourceNotFoundException("Category","id",postDto.getCategoryId()));
        // Convert DTO into Entity
        Post post = mapToEntity(postDto);
        post.setCategory(category);
        Post newPost = postRepository.save(post);
        // Convert entity into DTO
        return mapToDto(newPost);
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content = listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        Category category=categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(()->new ResourceNotFoundException("Category","id",postDto.getCategoryId()));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setCategory(category);
        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getPostByCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
        List<Post> posts=postRepository.findByCategoryId(categoryId);
        return posts.stream().map((post)->mapToDto(post))
                .collect(Collectors.toList());
    }

    // Convert entity into DTO
    private PostDto mapToDto(Post post) {

        return mapper.map(post, PostDto.class);
    }

    // Convert DTO to entity
    private Post mapToEntity(PostDto postDto) {

        return mapper.map(postDto, Post.class);
    }
}
