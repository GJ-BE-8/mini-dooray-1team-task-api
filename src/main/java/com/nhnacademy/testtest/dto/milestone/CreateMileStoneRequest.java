package com.nhnacademy.testtest.dto.milestone;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMileStoneRequest {
    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
