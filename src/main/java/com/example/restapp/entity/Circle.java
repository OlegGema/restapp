package com.example.restapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "circle_id",referencedColumnName = "id")
public @Data class Circle extends Element {
    private long radius;
}
