package com.nhnacademy.testtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectMember {


    @Id
    private long id;

    private String username;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String role;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
