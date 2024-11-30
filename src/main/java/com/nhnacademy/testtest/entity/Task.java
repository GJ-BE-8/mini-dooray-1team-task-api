package com.nhnacademy.testtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String title;

    @Setter
    private String content;

    @ManyToOne
    @Setter
    private Project project;

    @ManyToOne
    @Setter
    private ProjectMember projectMember;

    @OneToOne
    @Setter
    private MileStone mileStone;

    @ManyToOne
    @Setter
    private Tag tag;



}
