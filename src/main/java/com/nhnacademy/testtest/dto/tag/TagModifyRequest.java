package com.nhnacademy.testtest.dto.tag;

import lombok.Data;

@Data
public class TagModifyRequest {

    Long id;
    String name;
    Long projectId;
}
