package com.nhnacademy.testtest.service.project;

import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.entity.Project;

public interface ProjectService {

    Project createProject(ProjectPostRequest createCommendProject);

//    List<ProjectDto> getAllByProjectMemberId(Long projectMemberId);

    Project getProjectById(Long projectId);
}
