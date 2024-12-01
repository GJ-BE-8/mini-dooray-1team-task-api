package com.nhnacademy.testtest.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Project(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
