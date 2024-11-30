package com.nhnacademy.testtest.dto.milestone;

import lombok.Data;

@Data
public class ModifyMileStoneRequest {

    Long id;

    String name;

    Long projectId;
}
