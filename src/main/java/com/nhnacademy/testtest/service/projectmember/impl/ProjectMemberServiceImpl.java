package com.nhnacademy.testtest.service.projectmember.impl;

import com.nhnacademy.testtest.dto.proejctmember.CreateProjectMemberRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.exception.ProjectMemberNullPointException;
import com.nhnacademy.testtest.repository.ProjectMemberRepository;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;


    @Override
    public ProjectMember createProjectMember(CreateProjectMemberRequest createCommendProjectMember, Project project) {
        ProjectMember projectMember = new ProjectMember(createCommendProjectMember.getName(),
            createCommendProjectMember.getEmail(),
            Role.valueOf(createCommendProjectMember.getRole()), project);

        ProjectMember save = projectMemberRepository.save(projectMember);
        if(save == null) {
            throw new ProjectMemberNullPointException("Project Member is null");
        }
        return save;
    }
}
