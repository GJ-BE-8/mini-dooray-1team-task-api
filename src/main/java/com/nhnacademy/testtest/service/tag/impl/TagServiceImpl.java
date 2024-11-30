package com.nhnacademy.testtest.service.tag.impl;

import com.nhnacademy.testtest.dto.tag.CreateTagRequest;
import com.nhnacademy.testtest.dto.tag.TagDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Tag;
import com.nhnacademy.testtest.exception.TagNullPointException;
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
    public Tag createTag(CreateTagRequest request, Long projectId) {
        Project project = projectService.getProjectById(projectId).orElse(null);
        Tag tag = new Tag(request.getName(), project);
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(CreateTagRequest request, Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElse(null);
        if(tag == null) {
            throw new TagNullPointException("tag id null");
        }
        tag.setName(request.getName());
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Optional<TagDto> getTagById(Long tagId) {
        return tagRepository.findTagDtoById(tagId);
    }
}
