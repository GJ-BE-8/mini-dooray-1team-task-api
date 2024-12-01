package com.nhnacademy.testtest.service.milestone;

import com.nhnacademy.testtest.dto.milestone.MileStonePostRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneModifyRequest;
import com.nhnacademy.testtest.entity.MileStone;
import java.util.List;

public interface MileStoneService {

    MileStone createMileStone(MileStonePostRequest request);

    MileStone updateMileStone(MileStoneModifyRequest request);

    void deleteMileStone(long id);
    List<MileStone> getAllMileStones();

    MileStone getMileStoneById(Long id);
}
