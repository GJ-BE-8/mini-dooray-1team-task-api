package com.nhnacademy.testtest.dto.proejctmember;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectMemberRequest {

    String id;
    String name;
    String email;
    String role;
}
