package com.springboot.spring_boot_blog_app.service.impl;

import com.springboot.spring_boot_blog_app.entity.Category;
import com.springboot.spring_boot_blog_app.exception.ResourceNotFoundException;
import com.springboot.spring_boot_blog_app.payload.CategoryDto;
import com.springboot.spring_boot_blog_app.repository.CategoryRepository;
import com.springboot.spring_boot_blog_app.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category=modelMapper.map(categoryDto, Category.class);
        Category savedcategory=categoryRepository.save(category);
        return modelMapper.map(savedcategory,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
    Category category= categoryRepository.findById(categoryId).orElseThrow(()->
            new ResourceNotFoundException("category","id",categoryId));
        return modelMapper.map(category,CategoryDto.class);
    }
@Override
    public List<CategoryDto> getAllCategories(){
        List<Category> categories=categoryRepository.findAll();
        return categories.stream().map((category)->modelMapper.map(category,CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
     Category category= categoryRepository.findById(categoryId)
             .orElseThrow(()->new ResourceNotFoundException("CategoryDto","id",categoryId));
     category.setName(categoryDto.getName());
     category.setDescription(categoryDto.getDescription());
     category.setId(categoryId);

    Category updatedCategory= categoryRepository.save(category);
        return modelMapper.map(updatedCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category= categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("CategoryDto","id",categoryId));
        categoryRepository.delete(category);
    }
}
