package com.nhnacademy.testtest.service.projectmember.impl;

import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.repository.ProjectMemberRepository;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;


    @Override
    public void createProjectMember(ProjectMember projectMember) {
        projectMemberRepository.save(projectMember);
    }
}
