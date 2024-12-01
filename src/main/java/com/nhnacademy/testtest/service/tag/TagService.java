package com.nhnacademy.testtest.service.tag;

import com.nhnacademy.testtest.dto.tag.TagPostRequest;
import com.nhnacademy.testtest.dto.tag.TagModifyRequest;
import com.nhnacademy.testtest.entity.Tag;

public interface TagService {


    Tag createTag(TagPostRequest request);
    Tag updateTag(TagModifyRequest request);
    void deleteTag(Long tagId);

    // 수정한내용
    Tag getTagById(Long tagId);

//    Optional<TagDto> getTagById(Long tagId);
}
