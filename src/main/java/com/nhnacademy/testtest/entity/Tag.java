package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tag {

    @Id
    private long id;

    private String name;

    @ManyToOne
    private Project project;
}
