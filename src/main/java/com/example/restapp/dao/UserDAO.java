package com.example.restapp.dao;

import com.example.restapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User,Integer> {
    @Query("from User u where u.id=:id")
    User findById(@Param("id") int id);
}
