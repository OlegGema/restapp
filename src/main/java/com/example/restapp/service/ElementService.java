package com.example.restapp.service;



import com.example.restapp.entity.Element;
import java.util.Date;
import java.util.List;

public interface ElementService {
    void save(Element element);
    List<Element> findAll();
    List<Element>allSquares();
    List<Element>allCircles();
    List<Element>lastHour(Date date);
}
