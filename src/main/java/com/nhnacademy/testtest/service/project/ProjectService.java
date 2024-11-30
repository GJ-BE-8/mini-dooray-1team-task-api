package com.nhnacademy.testtest.service.project;

import com.nhnacademy.testtest.dto.project.CreateProjectRequest;
import com.nhnacademy.testtest.entity.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project createProject(CreateProjectRequest createCommendProject);

    List<Project> getAllByProjectMemberId(Long projectMemberId);

    Optional<Project> getProjectById(Long projectId);
}
