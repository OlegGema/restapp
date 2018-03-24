package com.example.restapp.dao;

import com.example.restapp.entity.UserElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserElementDAO extends JpaRepository<UserElement,Integer>{
}
