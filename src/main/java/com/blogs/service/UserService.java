package com.blogs.service;

import com.blogs.entity.User;


public interface UserService {
     String registerUser(User user);

    String loginUser(User user);
}
