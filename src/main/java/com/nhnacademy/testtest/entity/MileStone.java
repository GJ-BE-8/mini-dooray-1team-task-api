package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @Setter
    private LocalDateTime startTime;
    @Setter
    private LocalDateTime endTime;

    @ManyToOne
    @Setter
    private Project project;

    public MileStone(String name, LocalDateTime startTime, LocalDateTime endTime, Project project) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
