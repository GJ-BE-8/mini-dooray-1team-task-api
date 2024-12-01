package com.nhnacademy.testtest.dto.comment;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {
    Long id;

    String content;

    String author;

    LocalDateTime date;
}
