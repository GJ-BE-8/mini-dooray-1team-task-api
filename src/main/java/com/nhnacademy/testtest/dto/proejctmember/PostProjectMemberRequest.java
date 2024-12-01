package com.nhnacademy.testtest.dto.proejctmember;

import com.nhnacademy.testtest.entity.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostProjectMemberRequest {

    String name;
    String email;
    String role;
    Project project;
}
