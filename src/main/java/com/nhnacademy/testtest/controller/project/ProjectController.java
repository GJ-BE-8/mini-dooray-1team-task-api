package com.nhnacademy.testtest.controller.project;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<ProjectWithMemberDTO> createProject(@RequestBody ProjectPostRequest createCommendProject, PostProjectMemberRequest createCommendProjectMember) {

        //프로젝트 최초 생성할때 프로젝트 담당자를 저장하는 로직
        Project project = projectService.createProject(createCommendProject);
        ProjectMember projectMember = projectMemberService.createProjectMember(
            createCommendProjectMember);

        //DTO로 프로젝트와 함께 생성된 등록자를 함꼐 반환
        ProjectWithMemberDTO projectWithMemberDTO = new ProjectWithMemberDTO(project,
            projectMember);
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
