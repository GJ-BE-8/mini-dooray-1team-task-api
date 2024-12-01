package com.nhnacademy.testtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class ProjectMember {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @NonNull
    private String email;

    @Setter
    @Enumerated(value = EnumType.STRING)
    private Role role;


    @ManyToOne
    @Setter
    private Project project;

    public ProjectMember(String name, String email, Role role, Project project) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.project = project;
    }

}


