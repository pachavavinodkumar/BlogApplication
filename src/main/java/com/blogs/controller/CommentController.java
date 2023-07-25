package com.blogs.controller;

import com.blogs.entity.Comment;
import com.blogs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<Comment>> getCommentsByBlog(@PathVariable Long blogId){
        return ResponseEntity.ok(commentService.getCommentsByBlog(blogId));
    }
    @PostMapping("/comment/{blogId}")
    public ResponseEntity<String> commentOnBlog(@PathVariable Long blogId,@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.commentOnBlog(blogId,comment));
    }

}
