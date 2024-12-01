package com.nhnacademy.testtest.service.comment.impl;

import com.nhnacademy.testtest.dto.comment.CommentModifyRequest;
import com.nhnacademy.testtest.dto.comment.CommentPostRequest;
import com.nhnacademy.testtest.entity.Comment;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.exception.CommentNotFoundException;
import com.nhnacademy.testtest.repository.CommentRepository;
import com.nhnacademy.testtest.service.comment.CommentService;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import com.nhnacademy.testtest.service.task.TaskService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ProjectMemberService projectMemberService;

    @Override
    public Comment createCommend(CommentPostRequest request) {

        ProjectMember projectMemberById = projectMemberService.getProjectMemberById(
            request.getAuthorId());

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setCreatedAt(request.getDate());
        comment.setAuthor(projectMemberById);

        return commentRepository.save(comment);
    }

    @Override
    public Comment updateCommend(CommentModifyRequest request) {
        Comment comment = commentRepository.findById(request.getId()).orElse(null);
        comment.setContent(request.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteCommend(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment != null) {
            commentRepository.delete(comment);
        }else {
            throw new CommentNotFoundException("comment with id " + id + " not found");
        }
    }

    @Override
    public List<Comment> getAllByTaskId(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }
}
