package com.springboot.spring_boot_blog_app.service;

import com.springboot.spring_boot_blog_app.payload.PostDto;
import com.springboot.spring_boot_blog_app.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto,long id);

    void deletePostById(long id);
    List<PostDto> getPostByCategory(Long categoryId);
}
