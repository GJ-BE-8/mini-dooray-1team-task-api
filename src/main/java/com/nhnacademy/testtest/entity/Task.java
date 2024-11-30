package com.nhnacademy.testtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String title;

    @Setter
    private String content;

    @ManyToOne
    @Setter
    private Project project;

    @ManyToOne
    @Setter
    private ProjectMember projectMember;

    @OneToOne
    @Setter
    private MileStone mileStone;

    @ManyToOne
    @Setter
    private Tag tag;

    public Task(String title, String content, Project project, ProjectMember projectMember,
        MileStone mileStone, Tag tag) {
        this.title = title;
        this.content = content;
        this.project = project;
        this.projectMember = projectMember;
        this.mileStone = mileStone;
        this.tag = tag;
    }
}
