package com.nhnacademy.testtest.service.projectmember;

import com.nhnacademy.testtest.dto.proejctmember.CreateCommendProjectMember;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;

public interface ProjectMemberService {



    ProjectMember createProjectMember(CreateCommendProjectMember createCommendProjectMember);
}
