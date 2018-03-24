package com.example.restapp.service.impl;


import com.example.restapp.dao.UserElementDAO;
import com.example.restapp.entity.UserElement;
import com.example.restapp.service.UserElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserElementServiceImpl implements UserElementService {
    @Autowired
    UserElementDAO dao;
    @Override
    public void save(UserElement info) {
        dao.save(info);
    }

    @Override
    public List<UserElement> findAll() {
        return dao.findAll();
    }
}
