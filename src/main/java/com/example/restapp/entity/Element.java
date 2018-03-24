package com.example.restapp.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public @Data class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiredDate;
    private double square=0.0;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "element",cascade = CascadeType.ALL)
    public List<UserElement>userElementList;



    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addedDate='" + addedDate + '\'' +
                ", modifiredDate='" + modifiredDate + '\'' +
                ", square=" + square +
                ", userElementList=" + userElementList +
                '}';
    }
}
