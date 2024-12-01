package com.nhnacademy.testtest.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDTO {

    String title;

    String content;

    String author;

    String mileStoneName;

    String tagName;
}
