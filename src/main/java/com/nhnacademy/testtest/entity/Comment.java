package com.nhnacademy.testtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String content;

    @Setter
    private LocalDateTime createdAt;

    @ManyToOne
    @Setter
    private ProjectMember author;

    @ManyToOne
    private Task task;

    public Comment(String content, LocalDateTime date, Task task, ProjectMember projectMember) {
        this.content = content;
        this.date = date;
        this.task = task;
        this.projectMember = projectMember;
    }

}
