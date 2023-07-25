package com.blogs.service;

import com.blogs.entity.Comment;

import java.net.URI;
import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByBlog(Long blogId);

    String commentOnBlog(Long blogId, Comment comment);
}
