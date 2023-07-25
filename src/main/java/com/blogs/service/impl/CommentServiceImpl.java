package com.blogs.service.impl;

import com.blogs.entity.Blog;
import com.blogs.entity.Comment;
import com.blogs.repository.BlogRepository;
import com.blogs.repository.CommentRepository;
import com.blogs.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentServiceImpl(CommentRepository commentRepository,BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Comment> getCommentsByBlog(Long blogId) {
        return commentRepository.findByBlogId(blogId);
    }

    @Override
    public String commentOnBlog(Long blogId, Comment comment) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(blog.isPresent()) {
            Blog blogObject = blog.get();
            comment.setBlog(blogObject);
            List<Comment> comments = blogObject.getComments();
            comments.add(comment);
            blogObject.setComments(comments);
            blogRepository.save(blogObject);
            return "Success";
        }
        return "Blog Id "+blogId+" not found";
    }
}
