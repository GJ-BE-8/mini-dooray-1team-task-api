package com.nhnacademy.testtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


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

    public MileStone(String name, Project project) {
        this.name = name;
        this.project = project;
    }
}
