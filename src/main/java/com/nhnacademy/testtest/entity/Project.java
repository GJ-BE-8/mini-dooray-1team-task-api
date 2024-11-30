package com.nhnacademy.testtest.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Setter
    private Status status;

    public Project(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
