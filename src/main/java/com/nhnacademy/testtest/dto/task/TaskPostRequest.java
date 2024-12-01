package com.nhnacademy.testtest.dto.task;

import lombok.Data;

@Data
public class TaskPostRequest {

    //id 삭제(auto-increased)
    private String title;
    private String content;
    private Long projectId;
    private Long projectMemberId;
    private Long mileStoneId;
    private Long tagId;

}
