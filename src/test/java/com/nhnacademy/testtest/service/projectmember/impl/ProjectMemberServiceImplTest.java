package com.nhnacademy.testtest.service.projectmember.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.entity.Status;
import com.nhnacademy.testtest.exception.ProjectMemberNullPointException;
import com.nhnacademy.testtest.repository.ProjectMemberRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProjectMemberServiceImplTest {

    @InjectMocks
    private ProjectMemberServiceImpl projectMemberService;

    @Mock
    private ProjectMemberRepository projectMemberRepository;

    @Test
    void createProjectMember_Success() {
        // Given
        Project project = new Project("Test Project", Status.ACTIVATION);
        ProjectMember projectMember = new ProjectMember("John Doe", "john.doe@example.com", Role.ADMIN, project);
        ProjectPostRequest request = new ProjectPostRequest();
        request.setProject(project);
        request.setProjectMember(projectMember);

        when(projectMemberRepository.save(any(ProjectMember.class))).thenReturn(projectMember);

        PostProjectMemberRequest postProjectMemberRequest = new PostProjectMemberRequest();
        postProjectMemberRequest.setProject(project);
        postProjectMemberRequest.setName(projectMember.getName());
        postProjectMemberRequest.setEmail(projectMember.getEmail());
        postProjectMemberRequest.setRole(projectMember.getRole().toString());
        // When
        ProjectMember result = projectMemberService.createProjectMember(postProjectMemberRequest);

        // Then
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals(Role.ADMIN, result.getRole());
        verify(projectMemberRepository, times(1)).save(any(ProjectMember.class));
    }

    @Test
    void getProjectMemberById_Found() {
        // Given
        Long memberId = 1L;
        ProjectMember projectMember = new ProjectMember("Jane Doe", "jane.doe@example.com", Role.MEMBER, new Project());
        when(projectMemberRepository.findById(memberId)).thenReturn(Optional.of(projectMember));

        // When
        ProjectMember result = projectMemberService.getProjectMemberById(memberId);

        // Then
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        verify(projectMemberRepository, times(1)).findById(memberId);
    }

    @Test
    void getProjectMemberById_NotFound() {
        // Given
        Long memberId = 1L;
        when(projectMemberRepository.findById(memberId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ProjectMemberNullPointException.class, () -> {
            projectMemberService.getProjectMemberById(memberId);
        });
        verify(projectMemberRepository, times(1)).findById(memberId);
    }
}