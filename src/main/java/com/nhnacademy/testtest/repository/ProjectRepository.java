package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.dto.project.ProjectDto;
import com.nhnacademy.testtest.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {


//    @Query("select new com.nhnacademy.testtest.dto.project.ProjectDto(p.name,p.status) from Project p join ProjectMember pm on pm.project.id = p.id where pm.id =:memberId")
//    List<ProjectDto> findByProjectMemberId(@Param("memberId") Long memberId);
}
