package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
