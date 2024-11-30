package com.nhnacademy.testtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class MileStone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String name;

    @ManyToOne
    @Setter
    private Project project;

    public MileStone(String name, LocalDateTime startTime, LocalDateTime endTime, Project project) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
