package com.springboot.spring_boot_blog_app.service;

import com.springboot.spring_boot_blog_app.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId,CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId,long commentId);

    CommentDto updateComment(long postId,long CommentId,CommentDto commentRequest);
    void deleteComment(long postId,long commentId);
}
