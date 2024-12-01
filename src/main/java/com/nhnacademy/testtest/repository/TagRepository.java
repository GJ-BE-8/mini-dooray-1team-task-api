package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.dto.tag.TagDto;
import com.nhnacademy.testtest.entity.Tag;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> getTagById(long id);

//    @Query("select new com.nhnacademy.testtest.dto.tag.TagDto(t.name) from Tag t")
//    Optional<TagDto> findTagDtoById(long id);


}
