package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.dto.comment.CommentDto;
import com.nhnacademy.testtest.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Query("select new com.nhnacademy.testtest.dto.comment.CommentDto(c.id, c.content, c.author.name, c.createdAt) from Comment c left join Task t on t.id = c.task.id where t.id =:taskId")
    List<CommentDto> findByTaskId(@Param("taskId") Long taskId);
}
