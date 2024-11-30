package com.nhnacademy.testtest.dto.task;

import lombok.Data;

@Data
public class TaskRequest {

    private String title;

    private String tag;

    private String content;

    private Long mileStoneId;

}
