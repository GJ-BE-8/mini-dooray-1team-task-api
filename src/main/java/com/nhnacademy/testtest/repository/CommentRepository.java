package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findByTaskId(Long taskId);
}
