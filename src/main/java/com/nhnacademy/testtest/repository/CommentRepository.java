package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
