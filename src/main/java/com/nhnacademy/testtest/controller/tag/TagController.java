package com.nhnacademy.testtest.controller.tag;

import com.nhnacademy.testtest.dto.tag.CreateTagRequest;
import com.nhnacademy.testtest.entity.Tag;
import com.nhnacademy.testtest.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/tag")
@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody CreateTagRequest request, @RequestParam Long projectId) {
        tagService.createTag(request, projectId);

        Tag tag = tagService.createTag(request, projectId);
        return ResponseEntity.ok(tag);
    }


    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody CreateTagRequest request, @RequestParam Long tagId) {

        Tag tag = tagService.updateTag(request, tagId);
        return ResponseEntity.ok(tag);
    }

    @DeleteMapping
    public ResponseEntity<Tag> deleteTag(@RequestParam Long tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.ok().build();
    }
}
