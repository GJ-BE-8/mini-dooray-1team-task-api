package com.nhnacademy.testtest.service.tag.impl;

import com.nhnacademy.testtest.dto.tag.TagPostRequest;
import com.nhnacademy.testtest.dto.tag.TagModifyRequest;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Tag;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.exception.TagNullPointException;
import com.nhnacademy.testtest.repository.TagRepository;
import com.nhnacademy.testtest.repository.TaskRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.tag.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ProjectService projectService;
    private final TaskRepository taskRepository;

    @Override
    public Tag createTag(TagPostRequest request) {
        Project project = projectService.getProjectById(request.getProjectId());
        Tag tag = new Tag(request.getName(), project);
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(TagModifyRequest request) {
        Tag tag = tagRepository.findById(request.getId()).orElseThrow(
                () -> new TagNullPointException("해당하는 아이디의 태그가 존재하지 않습니다")
        );

        tag.setName(request.getName());
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElse(null);
        if (tag == null) {
            throw new TagNullPointException("해당하는 아이디의 태그가 존재하지 않습니다.");
        }
        List<Task> taskByTagId = taskRepository.findByTagId(tagId);
        for (Task task : taskByTagId) {
            task.setTag(null);
            taskRepository.save(task);
        }

        tagRepository.deleteById(tagId);
    }

    // 수정한내용
    @Override
    public Tag getTagById(Long tagId) {
        return tagRepository.getTagById(tagId).orElseThrow(
                ()->new TagNullPointException("해당 아이디의 tag가 존재하지 않습니다")
        );
    }
}
