package com.nhnacademy.testtest.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.repository.ProjectMemberRepository;
import com.nhnacademy.testtest.repository.ProjectRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
class ProjectControllerTest {


    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Test
    public void testFindByProjectMemberId() {
        // Given: 테스트 데이터 준비


        // When: 특정 멤버가 속한 프로젝트 조회
        List<Project> projects = projectRepository.findByProjectMemberId(member.());

        // Then: 조회 결과 검증
        assertThat(projects).isNotEmpty();
        assertThat(projects.get(0).getName()).isEqualTo("Test Project");
        assertThat(projects.get(0).getId()).isEqualTo(project.getId());
    }

}