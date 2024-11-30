package com.nhnacademy.testtest.dto.task;

import lombok.Data;

@Data
public class TaskModifyRequest {

    private Long id;
    private String title;
    private String content;
    private Long mileStoneId;
    private Long tagId;
}
