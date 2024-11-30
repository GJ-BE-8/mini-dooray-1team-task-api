package com.nhnacademy.testtest.service.task;

import com.nhnacademy.testtest.dto.task.TaskRequest;
import com.nhnacademy.testtest.entity.Task;

import java.util.List;

public interface TaskService {


    List<Task> getAllTasks();

    Task getTask(Long taskId);

    void postTask(TaskRequest taskPostRequest);

    void modifyTask(Long taskId, TaskRequest taskModifyRequest);

    void deleteTask(Long taskId);
}
