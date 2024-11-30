package com.nhnacademy.testtest.service.milestone;

import com.nhnacademy.testtest.dto.milestone.CreateMileStoneRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneDto;
import com.nhnacademy.testtest.dto.milestone.ModifyMileStoneRequest;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import java.util.List;

public interface MileStoneService {

    MileStone createMileStone(CreateMileStoneRequest request);

    MileStone updateMileStone(ModifyMileStoneRequest request);

    void deleteMileStone(long id);
    List<MileStone> getAllMileStones();

    MileStone getMileStoneById(Long id);
}
