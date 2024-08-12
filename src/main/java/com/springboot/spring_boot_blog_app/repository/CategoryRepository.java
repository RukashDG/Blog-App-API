package com.springboot.spring_boot_blog_app.repository;

import com.springboot.spring_boot_blog_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
