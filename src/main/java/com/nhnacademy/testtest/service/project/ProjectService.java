package com.nhnacademy.testtest.service.project;

import com.nhnacademy.testtest.dto.project.CreateCommendProject;
import com.nhnacademy.testtest.entity.Project;
import java.util.List;

public interface ProjectService {

    Project createProject(CreateCommendProject createCommendProject);

    List<Project> getAllByProjectMemberId(Long projectMemberId);
}
