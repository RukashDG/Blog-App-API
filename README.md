# Blog-App-API
Blog App API

Overview

The Blog App API is a comprehensive blogging platform developed using Spring Boot, Spring Security, JWT, Spring Data JPA (Hibernate), and MySQL. This application serves as a robust demonstration of building RESTful APIs with essential functionalities, providing a seamless experience for managing blog content and user authentication. The project showcases the integration of modern security practices, efficient data handling, and scalable architecture.

Features

Posting and Commenting

Blog Post Management:

Create: Add new blog posts.

Read: Retrieve posts by ID or list all posts.

Update: Modify existing posts.

Delete: Remove posts.

Comment Management:

Add Comments: Users can comment on blog posts.

View Comments: Retrieve comments associated with posts.

Delete Comments: Remove comments when needed.

Authentication and Authorization

User Management:

Signup: Register new users with secure credentials.
Login: Authenticate users and issue JWT tokens.
Role-Based Access Control: Implement different access levels based on user roles.

Secure APIs:

JWT Integration: Use JSON Web Tokens for secure API access.
Spring Security: Enforce authentication and authorization across the application.
Data Handling and Validation

DTOs and Lombok:

Data Transfer Objects: Use DTOs for efficient data transfer and management.
Lombok: Reduce boilerplate code with Lombok annotations.

Exception Handling:

Custom Exception Handling: Manage and respond to exceptions effectively.

Validation:

API Validation: Ensure data integrity and validation through Spring Boot.

Pagination and Sorting

Paginated Results:

Pagination: Retrieve paginated data for blog posts.

Sorting: Apply sorting based on various criteria (e.g., title, date).

Data Persistence and Querying

Spring Data JPA:

Query Methods: Implement custom query methods for data retrieval.

JPA Mappings: Use one-to-many and many-to-many mappings for complex data relationships.

API Testing

Postman: Test API endpoints and validate functionality using the Postman REST Client.

Technologies Used

Spring Boot - Framework for building Java-based applications.

Spring Security - Authentication and authorization framework.

JWT - Token-based authentication mechanism.

Spring Data JPA (Hibernate) - ORM framework for database interactions.

MySQL - Relational database management system.

Lombok - Library to reduce boilerplate code.

Postman - Tool for testing APIs.

Getting Started

Prerequisites

Java 17 or higher

Maven or Gradle

MySQL Database

Postman (for API testing)

Setup

Clone the Repository

git clone https://github.com/Rukash-tech/BlogApp.git

Configure MySQL Database:

Set up the database and update the configuration properties.

Build and Run the Application:

Use Maven or Gradle to build the project and run the application

API Endpoints

Blog Posts:

GET /api/posts - List all posts.

POST /api/posts - Create a new post.

GET /api/posts/{id} - Get a post by ID.

PUT /api/posts/{id} - Update a post.

DELETE /api/posts/{id} - Delete a post.

Authentication:

POST /api/auth/signup - Register a new user.

POST /api/auth/login - Login and get a JWT token.

Pagination and Sorting:

GET /api/posts?page=0&size=10&sort=title,desc - Paginated and sorted posts.

Contact

Author: Rukash DG

Email: rukashdg24@gmail.com

GitHub: https://github.com/Rukash-tech/BlogApp.git

