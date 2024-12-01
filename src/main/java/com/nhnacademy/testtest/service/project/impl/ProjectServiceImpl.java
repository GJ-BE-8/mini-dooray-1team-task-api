package com.nhnacademy.testtest.service.project.impl;

import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.repository.ProjectRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;


    @Override
    public Project createProject(ProjectPostRequest createCommendProject) {

        Project project = new Project(createCommendProject.getName(),
            createCommendProject.getStatus());
        if(project == null) {
            throw new ProjectNullPointException("project is null");
        }
        return projectRepository.save(project);

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
