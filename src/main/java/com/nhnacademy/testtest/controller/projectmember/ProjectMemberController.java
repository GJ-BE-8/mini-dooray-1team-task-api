package com.nhnacademy.testtest.controller.projectmember;

import com.nhnacademy.testtest.dto.proejctmember.CreateProjectMemberRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectMember> createProjectMember(@RequestBody CreateProjectMemberRequest request, @RequestParam Long projectId) {
        Project project = projectService.getProjectById(projectId).orElse(null);
        if(project == null) {
            throw new ProjectNullPointException("project is null");
        }
        ProjectMember projectMember = projectMemberService.createProjectMember(request, project);
        return ResponseEntity.ok().body(projectMember);
    }
}
