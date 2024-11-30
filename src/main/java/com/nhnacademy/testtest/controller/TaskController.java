package com.nhnacademy.testtest.controller;

import com.nhnacademy.testtest.dto.task.TaskDto;
import com.nhnacademy.testtest.dto.task.TaskRequest;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getTasks(){

        List<TaskDto> result= new ArrayList<>();

        for(Task task : taskService.getAllTasks()){

            TaskDto taskDto = new TaskDto();
            taskDto.createTaskDto(task.getId(),task.getTitle(), task.getContent(),task.getMileStone().getId());

            result.add(taskDto);
        }

        return result;
    }

    // TASK 갖고오기
    // 업무번호로 TASK 가져오기
    @GetMapping("/{taskId}")
    public TaskDto getTask(@PathVariable Long taskId){

        Task task = taskService.getTask(taskId);
        TaskDto taskDto = new TaskDto();
        taskDto.createTaskDto(task.getId(),task.getTitle(),task.getContent(),task.getMileStone().getId());

        return taskDto;
    }

    // TASK 등록
    @PostMapping
    public ResponseEntity postTask(@RequestBody TaskRequest taskPostRequest){
        taskService.postTask(taskPostRequest);
        return ResponseEntity.ok().build();
    }


    // TASK 수정
    @PutMapping("/{taskId}")
    public ResponseEntity  modifyTask(@PathVariable Long taskId, @RequestBody TaskRequest taskRequest){

        taskService.modifyTask(taskId,taskRequest);

        return ResponseEntity.ok().build();
    }

    // TASK 삭제
    @DeleteMapping("/{taskId}")
    public ResponseEntity deleteTask(@PathVariable Long taskId){

        taskService.deleteTask(taskId);

        return ResponseEntity.ok().build();
    }
}
