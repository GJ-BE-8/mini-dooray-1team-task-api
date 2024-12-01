package com.nhnacademy.testtest.service.comment.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.testtest.dto.comment.CommentDto;
import com.nhnacademy.testtest.dto.comment.CommentModifyRequest;
import com.nhnacademy.testtest.dto.comment.CommentPostRequest;
import com.nhnacademy.testtest.entity.Comment;
import com.nhnacademy.testtest.entity.ProjectMember;
import com.nhnacademy.testtest.exception.CommentNotFoundException;
import com.nhnacademy.testtest.repository.CommentRepository;
import com.nhnacademy.testtest.service.projectmember.ProjectMemberService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private ProjectMemberService projectMemberService;

    @Test
    void createCommend_Success() {
        // Given
        CommentPostRequest request = new CommentPostRequest();
        request.setContent("Test Comment");
        request.setAuthorId(1L);
        request.setDate(LocalDateTime.now());

        ProjectMember author = new ProjectMember();
        when(projectMemberService.getProjectMemberById(1L)).thenReturn(author);

        Comment savedComment = new Comment();
        savedComment.setContent(request.getContent());
        savedComment.setCreatedAt(request.getDate());
        savedComment.setAuthor(author);

        when(commentRepository.save(any(Comment.class))).thenReturn(savedComment);

        // When
        Comment result = commentService.createCommend(request);

        // Then
        assertNotNull(result);
        assertEquals("Test Comment", result.getContent());
        assertEquals(author, result.getAuthor());
        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void updateCommend_Success() {
        // Given
        CommentModifyRequest request = new CommentModifyRequest();
        request.setId(1L);
        request.setContent("Updated Comment");

        Comment existingComment = new Comment();
        existingComment.setContent("Original Comment");

        when(commentRepository.findById(1L)).thenReturn(Optional.of(existingComment));
        when(commentRepository.save(any(Comment.class))).thenReturn(existingComment);

        // When
        Comment result = commentService.updateCommend(request);

        // Then
        assertNotNull(result);
        assertEquals("Updated Comment", result.getContent());
        verify(commentRepository, times(1)).save(existingComment);
    }

    @Test
    void deleteCommend_Success() {
        // Given
        Long commentId = 1L;
        Comment comment = new Comment();
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        // When
        commentService.deleteCommend(commentId);

        // Then
        verify(commentRepository, times(1)).delete(comment);
    }

    @Test
    void deleteCommend_NotFound() {
        // Given
        Long commentId = 1L;
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(CommentNotFoundException.class, () -> {
            commentService.deleteCommend(commentId);
        });
    }

    @Test
    void getAllByTaskId_ReturnsComments() {
        // Given
        Long taskId = 1L;
        List<CommentDto> comments = List.of(
            new CommentDto(1L, "Comment 1", "Author 1", LocalDateTime.now()),
            new CommentDto(2L, "Comment 2", "Author 2", LocalDateTime.now())
        );

        when(commentRepository.findByTaskId(taskId)).thenReturn(comments);

        // When
        List<CommentDto> result = commentService.getAllByTaskId(taskId);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Comment 1", result.get(0).getContent());
        verify(commentRepository, times(1)).findByTaskId(taskId);
    }

}
