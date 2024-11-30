package com.nhnacademy.testtest.service.tag;

import com.nhnacademy.testtest.dto.tag.CreateTagRequest;
import com.nhnacademy.testtest.dto.tag.ModifyTagRequest;
import com.nhnacademy.testtest.dto.tag.TagDto;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Tag;
import java.util.Optional;

public interface TagService {


    Tag createTag(CreateTagRequest request);
    Tag updateTag(ModifyTagRequest request);
    void deleteTag(Long tagId);

    // 수정한내용
    Tag getTagById(Long tagId);

//    Optional<TagDto> getTagById(Long tagId);
}
