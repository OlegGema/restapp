package com.example.restapp.service;

import com.example.restapp.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(int id);
    List<User> findAll();
}
