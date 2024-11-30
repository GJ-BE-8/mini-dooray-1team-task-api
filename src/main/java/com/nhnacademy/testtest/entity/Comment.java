package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    private long id;

    private String content;

    private String author;

    private String date;

    @ManyToOne
    private Task task;

    @ManyToOne
    private ProjectMember projectMember;

}
