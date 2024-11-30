package com.nhnacademy.testtest.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {

    String content;

    String author;

    String date;
}
