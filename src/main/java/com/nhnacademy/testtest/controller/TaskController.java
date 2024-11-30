package com.nhnacademy.testtest.controller;

import com.nhnacademy.testtest.dto.TaskDto;
import com.nhnacademy.testtest.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // TASK 갖고오기
    // 업무번호로 TASK 가져오기
    @GetMapping("/{taskId}")
    public TaskDto getTask(@PathVariable String taskId){

        return null;
    }

    // TASK 등록
    @PostMapping
    public TaskDto postTask(){
        return null;
    }


    // TASK 수정
    @PutMapping("/{taskId}")
    public TaskDto modifyTask(@PathVariable String taskId){
        return null;
    }

    // TASK 삭제
    @DeleteMapping("/{taskId}")
    public TaskDto deleteTask(@PathVariable String taskId){
        return null;
    }
}
