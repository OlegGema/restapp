package com.example.restapp.service.impl;

import com.example.restapp.dao.UserDAO;
import com.example.restapp.entity.User;
import com.example.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSeviceImpl implements UserService {
    @Autowired
    UserDAO dao;

    @Override
    public void save(User user) {

        user.setName(user.getSaltString());
        dao.save(user);
    }

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
