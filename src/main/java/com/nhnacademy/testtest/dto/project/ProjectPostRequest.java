package com.nhnacademy.testtest.dto.project;

import com.nhnacademy.testtest.entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectPostRequest {

    String name;
    Status status;

}
