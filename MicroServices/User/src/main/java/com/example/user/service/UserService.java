package com.example.user.service;


import com.example.user.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void deleteUserById(int id);

}
