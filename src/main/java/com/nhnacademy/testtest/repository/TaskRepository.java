package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> getTaskById(long id);

    Optional<Task> findTaskByMileStone(MileStone mileStone);
}
