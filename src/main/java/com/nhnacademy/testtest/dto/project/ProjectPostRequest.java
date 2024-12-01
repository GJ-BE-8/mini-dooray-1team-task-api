package com.nhnacademy.testtest.dto.project;

import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectPostRequest {

    Project project;
    ProjectMember projectMember;

//    String name;
//    Status status;

}
