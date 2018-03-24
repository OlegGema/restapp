package com.example.restapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "square_id",referencedColumnName = "id")
public @Data class Square extends Element{
    private long borderSize;
}
