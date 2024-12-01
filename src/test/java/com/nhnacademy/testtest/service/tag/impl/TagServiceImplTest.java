package com.nhnacademy.testtest.service.tag.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nhnacademy.testtest.dto.tag.TagModifyRequest;
import com.nhnacademy.testtest.dto.tag.TagPostRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Status;
import com.nhnacademy.testtest.entity.Tag;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.exception.TagNullPointException;
import com.nhnacademy.testtest.repository.TagRepository;
import com.nhnacademy.testtest.repository.TaskRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @InjectMocks
    private TagServiceImpl tagService;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private ProjectService projectService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    void createTag_Success() {
        // Given
        TagPostRequest request = new TagPostRequest();
        request.setName("Test Tag");
        request.setProjectId(1L);

        Project project = new Project("Test Project", Status.ACTIVATION);

        when(projectService.getProjectById(1L)).thenReturn(project);
        when(tagRepository.save(any(Tag.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Tag result = tagService.createTag(request);

        // Then
        assertNotNull(result);
        assertEquals("Test Tag", result.getName());
        assertEquals(project, result.getProject());
        verify(tagRepository, times(1)).save(any(Tag.class));
    }

    @Test
    void updateTag_Success() {
        // Given
        TagModifyRequest request = new TagModifyRequest();
        request.setId(1L);
        request.setName("Updated Tag");

        Tag existingTag = new Tag("Old Tag", new Project());
        when(tagRepository.findById(1L)).thenReturn(Optional.of(existingTag));
        when(tagRepository.save(any(Tag.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Tag result = tagService.updateTag(request);

        // Then
        assertNotNull(result);
        assertEquals("Updated Tag", result.getName());
        verify(tagRepository, times(1)).save(existingTag);
    }

    @Test
    void updateTag_NotFound_ThrowsException() {
        // Given
        TagModifyRequest request = new TagModifyRequest();
        request.setId(1L);

        when(tagRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(TagNullPointException.class, () -> tagService.updateTag(request));
    }

    @Test
    void deleteTag_Success() {
        // Given
        Long tagId = 1L;
        Tag tag = new Tag("Test Tag", new Project());
        when(tagRepository.findById(tagId)).thenReturn(Optional.of(tag));
        when(taskRepository.findByTagId(tagId)).thenReturn(Collections.emptyList());

        // When
        tagService.deleteTag(tagId);

        // Then
        verify(tagRepository, times(1)).deleteById(tagId);
    }

    @Test
    void deleteTag_NotFound_ThrowsException() {
        // Given
        Long tagId = 1L;
        when(tagRepository.findById(tagId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(TagNullPointException.class, () -> tagService.deleteTag(tagId));
    }

    @Test
    void getTagById_Success() {
        // Given
        Long tagId = 1L;
        Tag tag = new Tag("Test Tag", new Project());
        when(tagRepository.getTagById(tagId)).thenReturn(Optional.of(tag));

        // When
        Tag result = tagService.getTagById(tagId);

        // Then
        assertNotNull(result);
        assertEquals("Test Tag", result.getName());
        verify(tagRepository, times(1)).getTagById(tagId);
    }

    @Test
    void getTagById_NotFound_ThrowsException() {
        // Given
        Long tagId = 1L;
        when(tagRepository.getTagById(tagId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(TagNullPointException.class, () -> tagService.getTagById(tagId));
    }

    @Test
    void deleteTag_WithAssociatedTasks() {
        // Given
        Long tagId = 1L;

        // 태그와 프로젝트 생성
        Tag tag = new Tag("Test Tag", new Project("Test Project", Status.ACTIVATION));

        // 태스크 생성 및 태그와 연결
        Task task1 = new Task("Task 1", "Content 1", tag.getProject(), null, null, tag);
        Task task2 = new Task("Task 2", "Content 2", tag.getProject(), null, null, tag);

        List<Task> tasks = List.of(task1, task2);

        // Mock 설정
        when(tagRepository.findById(tagId)).thenReturn(Optional.of(tag));
        when(taskRepository.findByTagId(tagId)).thenReturn(tasks);

        // When
        tagService.deleteTag(tagId);

        // Then
        // 태스크의 태그가 null로 설정되었는지 확인
        assertNull(task1.getTag());
        assertNull(task2.getTag());

        // 태스크가 저장되었는지 검증
        verify(taskRepository, times(1)).save(task1);
        verify(taskRepository, times(1)).save(task2);

        // 태그 삭제 확인
        verify(tagRepository, times(1)).deleteById(tagId);
    }
}
