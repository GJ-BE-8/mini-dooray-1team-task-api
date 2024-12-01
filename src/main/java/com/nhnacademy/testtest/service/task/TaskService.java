package com.nhnacademy.testtest.service.task;

import com.nhnacademy.testtest.dto.task.TaskCommentDTO;
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

    void update(Task task);

    TaskCommentDTO getTaskComment(Long taskId);

    List<Task> getTasksByProjectId(Long projectId);
}
