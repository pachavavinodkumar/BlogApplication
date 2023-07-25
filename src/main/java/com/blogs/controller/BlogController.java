package com.blogs.controller;

import com.blogs.entity.Blog;
import com.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
    @GetMapping("/my-blogs")
    public ResponseEntity<List<Blog>> getUserBlogs(){
       return new ResponseEntity<>(blogService.getUserBlogs(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBlog(@RequestBody Blog blog) {
        blogService.createBlog(blog);
       return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }


}
