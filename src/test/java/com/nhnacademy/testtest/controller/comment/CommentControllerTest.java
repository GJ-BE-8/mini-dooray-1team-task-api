package com.nhnacademy.testtest.controller.comment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.testtest.dto.comment.CommentDto;
import com.nhnacademy.testtest.dto.comment.CommentModifyRequest;
import com.nhnacademy.testtest.dto.comment.CommentPostRequest;
import com.nhnacademy.testtest.entity.Comment;
import com.nhnacademy.testtest.service.comment.CommentService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CommentController.class)
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CommentService commentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createComment_ReturnsCreatedComment() throws Exception {
        // Given
        CommentPostRequest request = new CommentPostRequest();
        request.setContent("Test Comment");
        request.setAuthorId(1L);
        request.setDate(LocalDateTime.now());

        Comment createdComment = new Comment();
        createdComment.setContent(request.getContent());

        when(commentService.createCommend(any(CommentPostRequest.class)))
            .thenReturn(createdComment);

        // When & Then
        mockMvc.perform(post("/api/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("Test Comment"));
    }

    @Test
    void updateComment_ReturnsUpdatedComment() throws Exception {
        // Given
        CommentModifyRequest request = new CommentModifyRequest();
        request.setId(1L);
        request.setContent("Updated Comment");

        Comment updatedComment = new Comment();

        updatedComment.setContent(request.getContent());
        when(commentService.updateCommend(any(CommentModifyRequest.class)))
            .thenReturn(updatedComment);

        // When & Then
        mockMvc.perform(put("/api/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("Updated Comment"));
    }

    @Test
    void deleteComment_ReturnsNoContent() throws Exception {
        // Given
        Long commentId = 1L;

        doNothing().when(commentService).deleteCommend(commentId);

        // When & Then
        mockMvc.perform(delete("/api/comment")
                .param("id", String.valueOf(commentId)))
            .andExpect(status().isNoContent());
    }

    @Test
    void getCommentsByTaskId_ReturnsCommentList() throws Exception {
        // Given
        Long taskId = 1L;
        List<CommentDto> comments = List.of(
            new CommentDto(1L, "Comment 1", "Author 1", LocalDateTime.now()),
            new CommentDto(2L, "Comment 2", "Author 2", LocalDateTime.now())
        );

        when(commentService.getAllByTaskId(taskId)).thenReturn(comments);

        // When & Then
        mockMvc.perform(get("/api/comment")
                .param("taskId", String.valueOf(taskId)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].content").value("Comment 1"))
            .andExpect(jsonPath("$[1].content").value("Comment 2"));
    }
}
