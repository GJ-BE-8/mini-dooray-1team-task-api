package com.nhnacademy.testtest.controller.tag;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.testtest.dto.tag.TagModifyRequest;
import com.nhnacademy.testtest.dto.tag.TagPostRequest;
import com.nhnacademy.testtest.entity.Tag;
import com.nhnacademy.testtest.service.tag.TagService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TagController.class)
class TagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TagService tagService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createTag_ReturnsCreatedTag() throws Exception {
        // Given
        TagPostRequest request = new TagPostRequest();
        request.setName("Test Tag");
        request.setProjectId(1L);

        Tag createdTag = new Tag();
        createdTag.setName("Test Tag");

        when(tagService.createTag(any(TagPostRequest.class))).thenReturn(createdTag);

        // When & Then
        mockMvc.perform(post("/api/tag")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Test Tag"));
    }

    @Test
    void updateTag_ReturnsUpdatedTag() throws Exception {
        // Given
        TagModifyRequest request = new TagModifyRequest();
        request.setId(1L);
        request.setName("Updated Tag");

        Tag updatedTag = new Tag();
        updatedTag.setName("Updated Tag");

        when(tagService.updateTag(any(TagModifyRequest.class))).thenReturn(updatedTag);

        // When & Then
        mockMvc.perform(put("/api/tag")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Updated Tag"));
    }

    @Test
    void deleteTag_ReturnsNoContent() throws Exception {
        // Given
        Long tagId = 1L;

        doNothing().when(tagService).deleteTag(tagId);

        // When & Then
        mockMvc.perform(delete("/api/tag")
                .param("tagId", String.valueOf(tagId)))
            .andExpect(status().isOk());
    }
}
