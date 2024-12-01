package com.nhnacademy.testtest.dto.proejctmember;

import com.nhnacademy.testtest.entity.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberDTO {

    String name;
    String email;
    String role;


    public ProjectMemberDTO(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;

    }
}