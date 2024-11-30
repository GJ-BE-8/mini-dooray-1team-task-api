package com.nhnacademy.testtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(nullable = false)
    @Setter
    private String name;

    @NonNull
    @Setter
    private String email;

    @Setter
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


