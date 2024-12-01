package com.nhnacademy.testtest.dto.proejctmember;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostProjectMemberRequest {

    Long id;
    String name;
    String email;
    String role;
    Long projectId;
}
