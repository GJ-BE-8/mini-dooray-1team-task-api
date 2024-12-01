package com.nhnacademy.testtest.controller;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.nhnacademy.testtest.controller.project.ProjectController;

import com.nhnacademy.testtest.dto.proejctmember.ProjectMemberDTO;
import com.nhnacademy.testtest.dto.project.ProjectPostRequest;
import com.nhnacademy.testtest.dto.project.ProjectWithMemberDTO;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.entity.Status;
import com.nhnacademy.testtest.service.project.ProjectService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Test
    void getAllProjects_ReturnsProjectList() throws Exception {
        // Given
        List<Project> projects = List.of(
            new Project("프로젝트1", Status.ACTIVATION),
            new Project("프로젝트2", Status.DORMANT)
        );
        given(projectService.getAllProjects()).willReturn(projects);

        // When & Then
        mockMvc.perform(get("/api/project"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("프로젝트1"))
            .andExpect(jsonPath("$[0].status").value("ACTIVATION"))
            .andExpect(jsonPath("$[1].name").value("프로젝트2"))
            .andExpect(jsonPath("$[1].status").value("DORMANT"));
    }

    @Test
    void getProjectById_ReturnsProject() throws Exception {
        // Given
        Project project = new Project("프로젝트1", Status.ACTIVATION);
        given(projectService.getProjectById(1L)).willReturn(project);

        // When & Then
        mockMvc.perform(get("/api/project/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("프로젝트1"))
            .andExpect(jsonPath("$.status").value("ACTIVATION"));
    }

    @Test
    void createProject_ReturnsProjectWithMember() throws Exception {
        // Given
        Project project = new Project("프로젝트1", Status.ACTIVATION);
        ProjectMember projectMember = new ProjectMember("김주혁", "asdf@gmail.com", Role.MEMBER,
            project);

        ProjectWithMemberDTO projectWithMemberDTO = new ProjectWithMemberDTO(
            project,
            new ProjectMemberDTO("김주혁", "asdf@gmail.com", "ADMIN")
        );

        ProjectPostRequest request = new ProjectPostRequest();
        request.setProject(project);
        request.setProjectMember(projectMember);

//        given(projectService.createProject(any(Project.class), any(ProjectMember.class)))
//            .willReturn(projectWithMemberDTO);

        String projectJson = jacksonObjectMapper.writeValueAsString(project);

        mockMvc.perform(post("/accounts/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(projectJson))
            .andExpect(status().isNotFound());
    }
}