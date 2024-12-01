package com.nhnacademy.testtest.service.comment;

import com.nhnacademy.testtest.dto.comment.CommentModifyRequest;
import com.nhnacademy.testtest.dto.comment.CommentPostRequest;
import com.nhnacademy.testtest.entity.Comment;
import java.util.List;

public interface CommentService {

    Comment createCommend(CommentPostRequest request);

    Comment updateCommend(CommentModifyRequest request);

    void deleteCommend(Long id);

    List<Comment> getAllByTaskId(Long taskId);
}
