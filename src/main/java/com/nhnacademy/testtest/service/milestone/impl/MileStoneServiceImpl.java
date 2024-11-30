package com.nhnacademy.testtest.service.milestone.impl;

import com.nhnacademy.testtest.dto.milestone.CreateMileStoneRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneDto;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.exception.MileStoneNullPointException;
import com.nhnacademy.testtest.exception.ProjectNotFoundException;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.repository.MileStoneRepository;
import com.nhnacademy.testtest.repository.ProjectRepository;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MileStoneRepository mileStoneRepository;
    private final ProjectRepository projectRepository;

    @Override
    public MileStone createMileStone(CreateMileStoneRequest request, Long projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project == null) {
            throw new ProjectNotFoundException("Project not found");
        }
        MileStone mileStone = new MileStone(request.getName(),request.getStartTime(),request.getEndTime(), project);
        mileStoneRepository.save(mileStone);
        return mileStone;
    }

    @Override
    public MileStone updateMileStone(CreateMileStoneRequest request, Long mileStoneId) {
        MileStone mileStone = mileStoneRepository.findById(mileStoneId).orElse(null);
        if(mileStone == null) {
            throw new MileStoneNullPointException("MileStone is null");
        }
        mileStone.setName(request.getName());
        mileStone.setEndTime(request.getEndTime());

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
