package com.nhnacademy.testtest.dto.task;

import lombok.Data;

@Data
public class TaskPostRequest {

    private Long id;
    private String title;
    private String content;
    private Long projectId;
    private Long projectMemberId;
    private Long mileStoneId;
    private Long tagId;

}
