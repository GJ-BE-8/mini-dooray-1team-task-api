package com.nhnacademy.testtest.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {

    String content;

    String author;

    String date;
}
