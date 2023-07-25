package com.blogs.service;

import com.blogs.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    List<Blog> getAllBlogs();

    List<Blog> getUserBlogs();

    Blog createBlog(Blog blog);
}
