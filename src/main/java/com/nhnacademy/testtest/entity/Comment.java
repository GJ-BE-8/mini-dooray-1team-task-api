package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String content;

    private LocalDateTime date;

    @ManyToOne
    private Task task;

    @ManyToOne
    private ProjectMember projectMember;

    public Comment(String content, LocalDateTime date, Task task, ProjectMember projectMember) {
        this.content = content;
        this.date = date;
        this.task = task;
        this.projectMember = projectMember;
    }

}
