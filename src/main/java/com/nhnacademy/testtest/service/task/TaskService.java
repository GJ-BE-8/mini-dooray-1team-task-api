package com.nhnacademy.testtest.service.task;

import com.nhnacademy.testtest.dto.task.TaskModifyRequest;
import com.nhnacademy.testtest.dto.task.TaskPostRequest;
import com.nhnacademy.testtest.entity.Task;

import java.util.List;

public interface TaskService {


    List<Task> getAllTasks();

    Task getTask(Long taskId);

    Task postTask(TaskPostRequest taskPostRequest);

    Task modifyTask(TaskModifyRequest taskModifyRequest);

    void deleteTask(Long taskId);

    List<Task> getTaskByMilestoneId(Long milestoneId);

    List<Task> getTaskByTagId(Long tagId);

    void update(Task task);
}
