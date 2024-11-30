package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
