package com.nhnacademy.testtest.service.task.impl;


import com.nhnacademy.testtest.dto.task.TaskRequest;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.exception.TaskNotFoundException;
import com.nhnacademy.testtest.repository.TaskRepository;
import com.nhnacademy.testtest.service.task.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
//    private final MileStoneService mileStoneService;


    @Override
    public List<Task> getAllTasks(){

        return taskRepository.findAll();
    }


    @Override
    public Task getTask(Long taskId){

        return taskRepository.getTaskById(taskId).orElseThrow(()->new TaskNotFoundException("해당 ID의 Task 존재하지 않습니다"));

    }

    @Override
    public void postTask(TaskRequest taskModifyRequest){

        Task task = new Task();
        task.setTitle(taskModifyRequest.getTitle());
        task.setContent(taskModifyRequest.getContent());
        task.setTag(taskModifyRequest.getTag());
//       MileStone mileStone = mileStoneService.getMileStoneById(taskModifyRequest.getMileStoneId()); 추후에 MileStone 로직 다 완성되면 동작가능
// 임시코드

        taskRepository.save(task);
        log.info("task 등록완료");
    }
    
    @Override
    public void modifyTask(Long taskId, TaskRequest taskModifyRequest){
        
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("해당 ID의 Task 존재하지 않습니다"));
        task.setTitle(taskModifyRequest.getTitle());
        task.setContent(taskModifyRequest.getContent());
        task.setTag(taskModifyRequest.getTag());
        // 마일스톤 수정도 추가해야함

        taskRepository.save(task);
        log.info("task 수정완료");
    }

    @Override
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }

}
