package com.nhnacademy.testtest.controller.projectmember;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.testtest.dto.proejctmember.PostProjectMemberRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.entity.Status;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProjectMemberController.class)
class ProjectMemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectMemberService projectMemberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createProjectMember_ReturnsCreatedMember() throws Exception {
        // Given
        PostProjectMemberRequest request = new PostProjectMemberRequest();
        request.setName("John Doe");
        request.setEmail("john.doe@example.com");
        request.setRole("ADMIN");
        request.setProject(new Project("Test Project", Status.ACTIVATION));

        ProjectMember projectMember = new ProjectMember(
            request.getName(),
            request.getEmail(),
            Role.valueOf(request.getRole()),
            request.getProject()
        );

        when(projectMemberService.createProjectMember(any(PostProjectMemberRequest.class)))
            .thenReturn(projectMember);

        // When & Then
        mockMvc.perform(post("/api/project-members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John Doe"))
            .andExpect(jsonPath("$.email").value("john.doe@example.com"))
            .andExpect(jsonPath("$.role").value("ADMIN"));
    }
}
