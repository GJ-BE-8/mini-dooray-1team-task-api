package com.nhnacademy.testtest.dto.task;

import lombok.Data;

@Data
public class TaskDto {
    private long id;

    private String title;

    private String content;



    private Long mileStone;

    public TaskDto createTaskDto(long id, String title,String content, Long mileStone){

        this.id = id;
        this.title = title;
        this.content =content;
        this.mileStone = mileStone;

        return this;
    }
}
