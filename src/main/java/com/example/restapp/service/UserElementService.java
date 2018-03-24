package com.example.restapp.service;



import com.example.restapp.entity.UserElement;


import java.util.List;

public interface UserElementService {
    void save(UserElement info);
    List<UserElement> findAll();
}
