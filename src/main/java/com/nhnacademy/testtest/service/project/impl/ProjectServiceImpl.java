package com.nhnacademy.testtest.service.project.impl;

import com.nhnacademy.testtest.dto.project.CreateProjectRequest;
import com.nhnacademy.testtest.dto.project.ProjectDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.repository.ProjectRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;


    @Override
    public Project createProject(CreateProjectRequest createCommendProject) {

        Project project = new Project(createCommendProject.getName(),
            createCommendProject.getStatus());
        if(project == null) {
            throw new ProjectNullPointException("project is null");
        }
        return projectRepository.save(project);

    }

    @Override
    public List<ProjectDto> getAllByProjectMemberId(Long projectMemberId) {
        return projectRepository.findByProjectMemberId(projectMemberId);
    }

    @Override
    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
