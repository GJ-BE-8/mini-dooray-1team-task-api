package com.nhnacademy.testtest.dto.milestone;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MileStoneDto {

    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
