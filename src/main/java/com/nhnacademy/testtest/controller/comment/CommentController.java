package com.nhnacademy.testtest.controller.comment;

import com.nhnacademy.testtest.dto.comment.CommentModifyRequest;
import com.nhnacademy.testtest.dto.comment.CommentPostRequest;
import com.nhnacademy.testtest.entity.Comment;
import com.nhnacademy.testtest.service.comment.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;


    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentPostRequest request) {
        Comment commend = commentService.createCommend(request);
        return ResponseEntity.ok(commend);
    }


    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody CommentModifyRequest request) {
        Comment comment = commentService.updateCommend(request);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping
    public ResponseEntity<Comment> deleteComment(@RequestParam Long id) {
        commentService.deleteCommend(id);
        return ResponseEntity.noContent().build();
    }




    //task에 해당하는 comments
    @GetMapping
    public ResponseEntity<List<Comment>> getCommentsByTaskId(@RequestParam Long taskId) {
        List<Comment> allByTaskId = commentService.getAllByTaskId(taskId);
        return ResponseEntity.ok(allByTaskId);
    }
}
