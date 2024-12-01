package com.nhnacademy.testtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String name;

    @Setter
    @ManyToOne
    private Project project;

    public Tag(String name, Project project) {
        this.name = name;
        this.project = project;
    }
}
