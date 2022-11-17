package com.example.user.controller;


import com.example.user.model.User;
import com.example.user.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/get")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getbyid/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public void saveUserDetails(@RequestBody User user){
        userService.saveUser(user);
    }

}
