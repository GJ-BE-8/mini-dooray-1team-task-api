package com.nhnacademy.testtest.service.comment.impl;

import com.nhnacademy.testtest.dto.comment.CreateCommentRequest;
import com.nhnacademy.testtest.entity.Comment;
import com.nhnacademy.testtest.repository.CommentRepository;
import com.nhnacademy.testtest.repository.TagRepository;
import com.nhnacademy.testtest.service.comment.CommentService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import com.nhnacademy.testtest.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskService taskService;
    private final ProjectMemberService projectMemberService;


    @Override
    public Comment createCommend(CreateCommentRequest request) {
        return null;
    }

    @Override
    public Comment updateCommend(CreateCommentRequest request) {
        return null;
    }

    @Override
    public void deleteCommend(Long id) {

    }
}