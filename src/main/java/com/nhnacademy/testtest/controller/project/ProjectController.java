package com.nhnacademy.testtest.controller.project;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.dto.proejctmember.ProjectMemberDTO;
import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.dto.project.ProjectWithMemberDTO;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.repository.ProjectRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){

        List<Project> projects =  projectService.getAllProjects();

        return ResponseEntity.ok(projects);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){

        Project project =  projectService.getProjectById(id);

        return ResponseEntity.ok(project);

    }


    @PostMapping
    public ResponseEntity<ProjectWithMemberDTO> createProject(@RequestBody ProjectPostRequest createCommendProject) {

        //프로젝트 최초 생성할때 프로젝트 담당자를 저장하는 로직
        Project project = createCommendProject.getProject();
        projectService.createProject(project, createCommendProject.getProjectMember());

        //DTO로 프로젝트와 함께 생성된 등록자를 함꼐 반환
        ProjectMember projectMember = createCommendProject.getProjectMember();
        ProjectWithMemberDTO projectWithMemberDTO = new ProjectWithMemberDTO(project, new ProjectMemberDTO(projectMember.getName(),projectMember.getEmail(), projectMember.getRole().name()));
        return ResponseEntity.ok(projectWithMemberDTO);
    }


    //프로젝트 맴버아이디로 프로젝트리스트 조회
//    @GetMapping
//    public ResponseEntity<List<ProjectDto>> projectList(@RequestParam Long memberId) {
//        List<ProjectDto> allByProjectMemberId = projectService.getAllByProjectMemberId(memberId);
//
//        return ResponseEntity.ok(allByProjectMemberId);
//    }





}
