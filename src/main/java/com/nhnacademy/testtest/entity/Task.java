package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {

    @Id
    private long id;


    private String title;

    private String tag;

    private String status;

    @ManyToOne
    private MileStone mileStone;
}
