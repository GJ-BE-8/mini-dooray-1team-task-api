package com.nhnacademy.testtest.service.comment;

import com.nhnacademy.testtest.dto.comment.CreateCommentRequest;
import com.nhnacademy.testtest.entity.Comment;

public interface CommentService {

    Comment createCommend(CreateCommentRequest request);

    Comment updateCommend(CreateCommentRequest request);

    void deleteCommend(Long id);
}
