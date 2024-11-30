package com.nhnacademy.testtest.controller.project;

import com.nhnacademy.testtest.dto.proejctmember.CreateCommendProjectMember;
import com.nhnacademy.testtest.dto.project.CreateCommendProject;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;


    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody CreateCommendProject createCommendProject, CreateCommendProjectMember createCommendProjectMember) {

        Project project = projectService.createProject(createCommendProject);
        projectMemberService.createProjectMember(createCommendProjectMember);

        return ResponseEntity.ok(project);
    }

    @GetMapping("{memberId}")
    public ResponseEntity<List<Project>> projectList(@RequestParam Long memberId) {
        projectService.getAllByProjectMemberId(memberId);
        return ResponseEntity.ok(projectService.getAllByProjectMemberId(memberId));
    }





}
