package com.nhnacademy.testtest.service.tag.impl;

import com.nhnacademy.testtest.dto.tag.CreateTagRequest;
import com.nhnacademy.testtest.dto.tag.TagDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Tag;
import com.nhnacademy.testtest.repository.TagRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.tag.TagService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ProjectService projectService;

    @Override
    public Tag CreateTag(CreateTagRequest request, Long projectId) {
        Project project = projectService.getProjectById(projectId).orElse(null);
        Tag tag = new Tag(request.getName(), project);
        return tagRepository.save(tag);
    }

    @Override
    public Tag UpdateTag(CreateTagRequest request, Long projectId) {
        Project project = projectService.getProjectById(projectId).orElse(null);
        Tag tag = new Tag(request.getName(), project);
        return tagRepository.save(tag);
    }

    @Override
    public void DeleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Optional<TagDto> GetTagById(Long tagId) {
        return tagRepository.findTagDtoById(tagId);
    }
}
