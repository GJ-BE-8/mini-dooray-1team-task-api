package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_members")
public class TaskMember {

    @Id
    private long id;

    private String role;

    @ManyToOne
    private Task task;

    @ManyToOne
    private ProjectMember projectMember;
}
