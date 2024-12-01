package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {


    List<ProjectMember> findProjectMembersByProject_Id(long projectId);
}
