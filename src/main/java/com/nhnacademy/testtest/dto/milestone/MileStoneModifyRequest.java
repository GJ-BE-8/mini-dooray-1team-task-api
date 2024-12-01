package com.nhnacademy.testtest.dto.milestone;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MileStoneModifyRequest {

    Long id;

    String name;

    Long projectId;
}
