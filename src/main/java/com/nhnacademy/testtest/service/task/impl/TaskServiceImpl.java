package com.nhnacademy.testtest.service.task.impl;


import com.nhnacademy.testtest.dto.comment.CommentDto;
import com.nhnacademy.testtest.dto.task.TaskCommentDTO;
import com.nhnacademy.testtest.dto.task.TaskModifyRequest;
import com.nhnacademy.testtest.dto.task.TaskPostRequest;
import com.nhnacademy.testtest.entity.*;
import com.nhnacademy.testtest.exception.DuplicatedMileStoneException;
import com.nhnacademy.testtest.exception.TaskNotFoundException;
import com.nhnacademy.testtest.repository.CommentRepository;
import com.nhnacademy.testtest.repository.TaskRepository;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import com.nhnacademy.testtest.service.tag.TagService;
import com.nhnacademy.testtest.service.task.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MileStoneService mileStoneService;
    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;
    private final TagService tagService;
    private final CommentRepository commentRepository;


    @Override
    public List<Task> getAllTasks(){

        return taskRepository.findAll();

    }


    @Override
    public Task getTask(Long taskId){

        return taskRepository.getTaskById(taskId).orElseThrow(()->new TaskNotFoundException("해당 ID의 Task 존재하지 않습니다"));

    }

    @Override
    public Task postTask(TaskPostRequest taskPostRequest){

        Task task = new Task();
        task.setTitle(taskPostRequest.getTitle());
        task.setContent(taskPostRequest.getContent());

        // 추가된내용!
        Project project = projectService.getProjectById(taskPostRequest.getProjectId());
        ProjectMember projectMember = projectMemberService.getProjectMemberById(taskPostRequest.getProjectMemberId());
        MileStone mileStone = mileStoneService.getMileStoneById(taskPostRequest.getMileStoneId());
        Tag tag = tagService.getTagById(taskPostRequest.getTagId());

        // 이미 같은 마일스톤 쓰고잇는 업무 잇다면 예외 발생 예외발생

        Task alreadyAssignedMileStone = taskRepository.findTaskByMileStone(mileStone).orElse(null);
        if(Objects.nonNull(alreadyAssignedMileStone)){
          throw new DuplicatedMileStoneException("해당 마일스톤은 이미 다른 업무에 배정되어 있습니다");
        }

        task.setProject(project);
        task.setProjectMember(projectMember);
        task.setMileStone(mileStone);
        task.setTag(tag);
// 임시코드
        return taskRepository.save(task);
    }
    
    @Override
    public Task modifyTask(TaskModifyRequest taskModifyRequest){
        
        Task task = taskRepository.findById(taskModifyRequest.getId()).orElseThrow(()->new TaskNotFoundException("해당 ID의 Task 존재하지 않습니다"));
        task.setTitle(taskModifyRequest.getTitle());
        task.setContent(taskModifyRequest.getContent());

        MileStone mileStone = mileStoneService.getMileStoneById(taskModifyRequest.getMileStoneId());
        Tag tag = tagService.getTagById(taskModifyRequest.getTagId());

        // 이미 같은 마일스톤 쓰고잇는 업무 잇다면 예외 발생

        Task alreadyAssignedMileStone = taskRepository.findTaskByMileStone(mileStone).orElse(null);
        if(Objects.nonNull(alreadyAssignedMileStone)){
            throw new DuplicatedMileStoneException("해당 마일스톤은 이미 다른 업무에 배정되어 있습니다");
        }
        task.setMileStone(mileStone);
        task.setTag(tag);

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }


    //마엘스톤과 태그를 널로 업데이트하기위한 메서드
    @Override
    public void update(Task task) {
        taskRepository.save(task);
    }

    @Override
    public TaskCommentDTO getTaskComment(Long taskId) {
        TaskCommentDTO taskDTO = taskRepository.findByTaskId(taskId);
        List<CommentDto> comments = commentRepository.findByTaskId(taskId);
        taskDTO.setComments(comments);

        return taskDTO;
    }

}
