package com.nhnacademy.testtest.service.projectmember;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {



    ProjectMember createProjectMember(PostProjectMemberRequest createCommendProjectMember);

    ProjectMember getProjectMemberById(Long id);

    List<ProjectMember> getProjectMemberByProjectId(Long id);
}
