package com.example.task311.service;

import com.example.task311.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
