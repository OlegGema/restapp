package com.example.restapp.service.impl;

import com.example.restapp.dao.ElementDAO;
import com.example.restapp.entity.Element;
import com.example.restapp.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ElementServiceImpl implements ElementService {
    @Autowired
    ElementDAO dao;



    @Override
    public void save(Element element) {
        dao.save(element);
    }

    @Override
    public List<Element> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Element> allSquares() {
        return dao.allSquares();
    }

    @Override
    public List<Element> allCircles() {
        return dao.allCircles();
    }

    @Override
    public List<Element> lastHour(Date date) {
        return dao.lastHour(date);
    }

}
