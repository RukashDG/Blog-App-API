package com.springboot.spring_boot_blog_app.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min=2,message = "Post title should have atleast 2 characters")
    //it should not be null or empty or it should have atleast 2 characters
    private String title;

    //it should not be null or empty and it should have atleast 10 characters
    @Size(min=10,message = "Post description should have atleast 10 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
    private Long categoryId;
}
