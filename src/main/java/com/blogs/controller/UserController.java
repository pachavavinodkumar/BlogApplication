package com.blogs.controller;


import com.blogs.entity.User;
import com.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

   private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        String response = userService.registerUser(user);
        if(response.equals("Username already exists"))
            return new ResponseEntity<>(response,HttpStatus.CONFLICT);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
   /* @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user){
        String response = userService.loginUser(user);
        if(response.equals("Invalid credentials"))
            return new ResponseEntity<>(response,HttpStatus.CONFLICT);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }*/
}
