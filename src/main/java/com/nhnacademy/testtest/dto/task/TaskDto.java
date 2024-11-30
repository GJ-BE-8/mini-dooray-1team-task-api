package com.nhnacademy.testtest.dto.task;

import lombok.Data;

@Data
public class TaskDto {
    private long id;

    private String title;

    private String tag;

    private String status;

    private Long mileStone;

    public TaskDto createTaskDto(long id, String title,String tag,String status, Long mileStone){

        this.id = id;
        this.title = title;
        this.tag =tag;
        this.status = status;
        this.mileStone = mileStone;

        return this;
    }
}
