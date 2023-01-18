package com.example.task311.dao;

import com.example.task311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getUsers();
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
