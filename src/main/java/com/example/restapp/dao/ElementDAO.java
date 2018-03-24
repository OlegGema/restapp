package com.example.restapp.dao;

import com.example.restapp.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ElementDAO extends JpaRepository<Element,Integer> {
    @Query("from Element where radius=null")
    List<Element>allSquares();

    @Query("from Element where borderSize=null")
    List<Element>allCircles();

    @Query("from Element where addedDate>:date")
    List<Element>lastHour(@Param("date")Date date);


}
