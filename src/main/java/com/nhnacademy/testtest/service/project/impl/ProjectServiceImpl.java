package com.nhnacademy.testtest.service.project.impl;

import com.nhnacademy.testtest.dto.CreateCommendProject;
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
    public Project createProject(CreateCommendProject createCommendProject) {

        Project project = new Project(createCommendProject.getName(),
            createCommendProject.getStatus());
        if(project == null) {
            throw new ProjectNullPointException("project is null");
        }
        return projectRepository.save(project);

    }
}
