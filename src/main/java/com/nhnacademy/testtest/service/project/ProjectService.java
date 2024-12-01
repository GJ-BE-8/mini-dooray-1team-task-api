package com.nhnacademy.testtest.service.project;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;

public interface ProjectService {

    Project createProject(Project project, ProjectMember projectMember);

//    List<ProjectDto> getAllByProjectMemberId(Long projectMemberId);

    Project getProjectById(Long projectId);
}
