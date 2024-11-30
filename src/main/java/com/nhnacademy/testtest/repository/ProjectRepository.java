package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query("select p from Project p join ProjectMember pm where pm.id = :memberId")
    List<Project> findByProjectMemberId(@Param("memberId") Long memberId);
}
