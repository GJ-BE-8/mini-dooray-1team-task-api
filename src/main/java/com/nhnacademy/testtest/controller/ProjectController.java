package com.nhnacademy.testtest.controller;

import com.nhnacademy.testtest.dto.CreateCommendProject;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;


    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody CreateCommendProject createCommendProject) {

        Project project = projectService.createProject(createCommendProject);


        return ResponseEntity.ok(project);
    }


}
