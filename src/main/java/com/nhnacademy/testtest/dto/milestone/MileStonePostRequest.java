package com.nhnacademy.testtest.dto.milestone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MileStonePostRequest {

    Long milestoneId;

    String name;

    Long projectId;
}
