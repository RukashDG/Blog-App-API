package com.springboot.spring_boot_blog_app.repository;

import com.springboot.spring_boot_blog_app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //List<Comment> findById(long PostId);

    List<Comment> findByPostId(long postId);
}
