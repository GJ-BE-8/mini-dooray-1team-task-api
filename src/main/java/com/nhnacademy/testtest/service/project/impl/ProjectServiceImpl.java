package com.nhnacademy.testtest.service.project.impl;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.exception.ProjectMemberNullPointException;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.repository.ProjectMemberRepository;
import com.nhnacademy.testtest.repository.ProjectRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;


    @Override
    public Project createProject(Project project, ProjectMember projectMember) {


        Project saveProject = projectRepository.save(project);
        projectMember.setProject(saveProject);

        ProjectMember saveProjectMember = projectMemberRepository.save(projectMember);
        if(saveProjectMember == null){
            throw new ProjectMemberNullPointException("projectMember is null");
        }
        return project;
    }

//    @Override
//    public List<ProjectDto> getAllByProjectMemberId(Long projectMemberId) {
//        return projectRepository.findByProjectMemberId(projectMemberId);
//    }

    @Override
    public Project getProjectById(Long projectId) {

        Project project = projectRepository.findById(projectId).orElseThrow(
                ()->new ProjectNullPointException("해당 아이디의 프로젝트를 찾을수 없습니다")
        );

        return project;
    }
}
