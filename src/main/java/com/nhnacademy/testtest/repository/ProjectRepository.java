package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
