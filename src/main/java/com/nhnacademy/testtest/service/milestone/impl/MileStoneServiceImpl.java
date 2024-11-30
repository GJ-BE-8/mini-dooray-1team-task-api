package com.nhnacademy.testtest.service.milestone.impl;

import com.nhnacademy.testtest.dto.milestone.CreateMileStoneRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneDto;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.repository.MileStoneRepository;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MileStoneRepository mileStoneRepository;

    @Override
    public MileStone createMileStone(CreateMileStoneRequest request, Project project) {
        MileStone mileStone = new MileStone(request.getName(),request.getStartTime(),request.getEndTime(), project);
        mileStoneRepository.save(mileStone);
        return mileStone;
    }

    @Override
    public MileStone updateMileStone(CreateMileStoneRequest request, Project project) {
        MileStone mileStone = new MileStone(request.getName(),request.getStartTime(),request.getEndTime(), project);
        mileStoneRepository.save(mileStone);
        return mileStone;
    }

    @Override
    public void deleteMileStone(long id) {
        mileStoneRepository.deleteById(id);
    }


    @Override
    public List<MileStoneDto> getAllMileStones() {
        return mileStoneRepository.findAllBy();
    }
}
