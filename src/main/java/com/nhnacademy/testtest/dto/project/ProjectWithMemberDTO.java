package com.nhnacademy.testtest.dto.project;

import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProjectWithMemberDTO {
    private Project project;
    private ProjectMember projectMember;
}
