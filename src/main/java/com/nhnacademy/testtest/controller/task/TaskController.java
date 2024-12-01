package com.nhnacademy.testtest.controller.task;

import com.nhnacademy.testtest.dto.task.TaskDTO;

import com.nhnacademy.testtest.dto.task.TaskModifyRequest;
import com.nhnacademy.testtest.dto.task.TaskPostRequest;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // 프로젝트의 Task 전체 가져오기
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    // 프로젝트 아이디로 업무목록 받아오기
    @GetMapping(params ="projectId" )
    public ResponseEntity<List<Task>> getTasksByProjectId(@RequestParam Long projectId){

        List<Task> tasks = taskService.getTasksByProjectId(projectId);

        return ResponseEntity.ok(tasks);
    }

    // TASK 갖고오기
    // 업무번호로 TASK 가져오기
    @GetMapping("/{taskId}")
    public TaskCommentDTO getTask(@PathVariable Long taskId){
        return taskService.getTaskComment(taskId);
    }

    @GetMapping(path = "{projectMemberId}")
    public List<TaskDTO> getTaskByProjectMemberId(@RequestParam Long projectMemberId){
        return taskService.getTaskByProjectMemberId(projectMemberId);
    }

    // TASK 등록
    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody TaskPostRequest taskPostRequest){
        Task task = taskService.postTask(taskPostRequest);
        return ResponseEntity.ok(task);
    }

    // TASK 수정
    @PutMapping("/{taskId}")
    public ResponseEntity<Task>  modifyTask(@RequestBody TaskModifyRequest taskModifyRequest){
        Task task = taskService.modifyTask(taskModifyRequest);
        return ResponseEntity.ok(task);
    }

    // TASK 삭제
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long taskId){

        taskService.deleteTask(taskId);

        return ResponseEntity.ok().build();
    }
}
