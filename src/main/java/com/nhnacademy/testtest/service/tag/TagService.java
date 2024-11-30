package com.nhnacademy.testtest.service.tag;

import com.nhnacademy.testtest.dto.tag.CreateTagRequest;
import com.nhnacademy.testtest.dto.tag.TagDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Tag;
import java.util.Optional;

public interface TagService {


    Tag createTag(CreateTagRequest request, Long projectId);
    Tag updateTag(CreateTagRequest request, Long tagId);
    void deleteTag(Long tagId);

    Optional<TagDto> getTagById(Long tagId);
}
