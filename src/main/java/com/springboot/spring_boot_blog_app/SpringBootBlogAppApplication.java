package com.springboot.spring_boot_blog_app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBlogAppApplication {
@Bean
	public ModelMapper modelMapper(){

	return new ModelMapper();
	}

	public static void main(String[] args) {

	SpringApplication.run(SpringBootBlogAppApplication.class, args);
	}

}
