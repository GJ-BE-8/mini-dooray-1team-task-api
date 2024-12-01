package com.nhnacademy.testtest.service.comment;

import com.nhnacademy.testtest.dto.comment.CommentPostRequest;
import com.nhnacademy.testtest.entity.Comment;

public interface CommentService {

    Comment createCommend(CommentPostRequest request);

    Comment updateCommend(CommentPostRequest request);

    void deleteCommend(Long id);
}
