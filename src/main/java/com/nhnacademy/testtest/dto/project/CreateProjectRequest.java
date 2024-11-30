package com.nhnacademy.testtest.dto.project;

import com.nhnacademy.testtest.entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequest {


    String name;
    Status status;
}
