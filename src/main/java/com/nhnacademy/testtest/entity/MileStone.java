package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class MileStone {

    @Id
    private long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Project project;
}
