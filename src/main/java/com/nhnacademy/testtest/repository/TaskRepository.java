package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.dto.task.TaskDTO;

import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> getTaskById(long id);

    Optional<Task> findTaskByMileStone(MileStone mileStone);

    List<Task> findByMileStoneId(long id);

    List<Task> findByTagId(long id);

    @Query("select new com.nhnacademy.testtest.dto.task.TaskDTO(t.title, t.content, t.projectMember.name, t.mileStone.name, t.tag.name) from Task t JOIN Project p on p.id = t.project.id join ProjectMember pm on pm.project.id = p.id where pm.id = :projectMemberId")
    List<TaskDTO> findTaskByProjectMemberId(long projectMemberId);

}
