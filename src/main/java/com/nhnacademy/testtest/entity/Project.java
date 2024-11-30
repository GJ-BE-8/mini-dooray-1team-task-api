package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Project {

    @Id
    private long id;

    private String name;

    private String status;

    public Project(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
