package com.nhnacademy.testtest.controller.projectmember;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;


    @PostMapping
    public ResponseEntity<ProjectMember> createProjectMember(@RequestBody PostProjectMemberRequest request) {

        ProjectMember projectMember = projectMemberService.createProjectMember(request);
        return ResponseEntity.ok().body(projectMember);
    }
}
