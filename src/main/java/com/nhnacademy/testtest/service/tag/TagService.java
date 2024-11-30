package com.nhnacademy.testtest.service.tag;

import com.nhnacademy.testtest.dto.tag.CreateTagRequest;
import com.nhnacademy.testtest.dto.tag.TagDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Tag;
import java.util.Optional;

public interface TagService {


    Tag CreateTag(CreateTagRequest request, Long projectId);
    Tag UpdateTag(CreateTagRequest request, Long projectId);
    void DeleteTag(Long tagId);

    Optional<TagDto> GetTagById(Long tagId);
}
