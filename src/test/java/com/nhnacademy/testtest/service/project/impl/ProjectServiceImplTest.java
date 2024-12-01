package com.nhnacademy.testtest.service.project.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.entity.Role;
import com.nhnacademy.testtest.entity.Status;
import com.nhnacademy.testtest.exception.ProjectMemberNullPointException;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.repository.ProjectMemberRepository;
import com.nhnacademy.testtest.repository.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectServiceImpl projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Test
    void testCreateProjectAndMember() {
        // Given
//        Project project = new Project("프로젝트1", "ACTIVATION");
//        ProjectMember member = new ProjectMember("김주혁", "asdf@gmail.com", "ADMIN");
        Project project = new Project("project", Status.ACTIVATION);

        ProjectMember member = new ProjectMember("김주혁", "asdf@gmail.com", Role.ADMIN, project);

        // When
        Project savedProject = projectService.createProject(project, member);

        // Then
        assertNotNull(savedProject);
        assertEquals("project", savedProject.getName());
        assertEquals(Status.ACTIVATION, savedProject.getStatus());


    }

    @Test
    void testGetProjectById() {
        // Given
        Project project = new Project("프로젝트2", Status.ACTIVATION);
        Project savedProject = projectRepository.save(project);

        // When
        Project foundProject = projectService.getProjectById(savedProject.getId());

        // Then
        assertNotNull(foundProject);
        assertEquals("프로젝트2", foundProject.getName());
        assertEquals(Status.ACTIVATION, foundProject.getStatus());
    }

    @Test
    void getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        assertNotNull(projects);
    }

    @Test
    void projectNullTest(){

        Project project = new Project("프로젝트1", Status.ACTIVATION);
        ProjectMember projectMember = null;

        assertThrows(ProjectNullPointException.class, () -> {projectService.getProjectById(132213l);});

    }
}
