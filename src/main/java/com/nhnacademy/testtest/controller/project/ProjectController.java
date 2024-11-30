package com.nhnacademy.testtest.controller.project;

import com.nhnacademy.testtest.dto.proejctmember.CreateProjectMemberRequest;
import com.nhnacademy.testtest.dto.project.CreateProjectRequest;
import com.nhnacademy.testtest.dto.project.ProjectDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.repository.ProjectRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;

    private final ProjectRepository projectRepository;


    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectRequest createCommendProject, CreateProjectMemberRequest createCommendProjectMember) {

        //프로젝트 최초 생성할때 프로젝트 담당자를 저장하는 로직
        Project project = projectService.createProject(createCommendProject);
        projectMemberService.createProjectMember(createCommendProjectMember, project);

        return ResponseEntity.ok(project);
    }


    //프로젝트 맴버아이디로 프로젝트리스트 조회
//    @GetMapping
//    public ResponseEntity<List<ProjectDto>> projectList(@RequestParam Long memberId) {
//        List<ProjectDto> allByProjectMemberId = projectService.getAllByProjectMemberId(memberId);
//
//        return ResponseEntity.ok(allByProjectMemberId);
//    }





}
