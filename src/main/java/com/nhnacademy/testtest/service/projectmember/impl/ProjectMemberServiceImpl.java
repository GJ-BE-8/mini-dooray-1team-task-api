package com.nhnacademy.testtest.service.projectmember.impl;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
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
    public ProjectMember createProjectMember(PostProjectMemberRequest createCommendProjectMember) {

        ProjectMember projectMember = new ProjectMember(createCommendProjectMember.getName(),
            createCommendProjectMember.getEmail(),
            Role.valueOf(createCommendProjectMember.getRole()), createCommendProjectMember.getProject());

        return projectMemberRepository.save(projectMember);
    }


    // 추가된내용!
    @Override
    public ProjectMember getProjectMemberById(Long id){
        return projectMemberRepository.findById(id).orElseThrow(
                ()-> new ProjectMemberNullPointException("해당 ID의 ProjectMember가 존재하지 않습니다")
        );
    }
}
