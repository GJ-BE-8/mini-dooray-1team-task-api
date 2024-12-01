package com.nhnacademy.testtest.controller.projectmember;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping(params = "projectId")
    public ResponseEntity<List<ProjectMember>> getProjectMembersByProjectId(@RequestParam Long projectId){

        List<ProjectMember> projectList = projectMemberService.getProjectMemberByProjectId(projectId);
        return ResponseEntity.ok(projectList);

    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ProjectMember> getProjectMembersByMemberId(@PathVariable Long memberId){

        ProjectMember projectMember = projectMemberService.getProjectMemberById(memberId);
        return ResponseEntity.ok(projectMember);

    }


    @PostMapping
    public ResponseEntity<ProjectMember> createProjectMember(@RequestBody PostProjectMemberRequest request) {

        ProjectMember projectMember = projectMemberService.createProjectMember(request);
        return ResponseEntity.ok().body(projectMember);
    }
}
