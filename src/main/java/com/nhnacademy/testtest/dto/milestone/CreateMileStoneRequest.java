package com.nhnacademy.testtest.dto.milestone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMileStoneRequest {

    String name;

    Long projectId;
}
