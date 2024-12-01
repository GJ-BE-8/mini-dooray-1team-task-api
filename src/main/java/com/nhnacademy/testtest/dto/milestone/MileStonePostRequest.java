package com.nhnacademy.testtest.dto.milestone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MileStonePostRequest {

    Long milestoneId;

    String name;

    Long projectId;
}
