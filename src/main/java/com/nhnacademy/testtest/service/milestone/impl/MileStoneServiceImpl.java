package com.nhnacademy.testtest.service.milestone.impl;

import com.nhnacademy.testtest.dto.milestone.MileStonePostRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneModifyRequest;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.exception.MileStoneNullPointException;
import com.nhnacademy.testtest.repository.MileStoneRepository;
import com.nhnacademy.testtest.repository.TaskRepository;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import com.nhnacademy.testtest.service.task.TaskService;
import java.util.List;

import com.nhnacademy.testtest.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MileStoneRepository mileStoneRepository;
    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    @Override
    public MileStone createMileStone(MileStonePostRequest request) {
        Project project = projectService.getProjectById(request.getProjectId());
        MileStone mileStone = new MileStone(request.getName(), project);
        mileStoneRepository.save(mileStone);
        return mileStone;
    }

    @Override
    public MileStone updateMileStone(MileStoneModifyRequest request) {

        MileStone mileStone = mileStoneRepository.findById(request.getId()).orElseThrow(
                ()-> new MileStoneNullPointException("해당 아이디의 mileStone이 존재하지 않습니다")
        );

        mileStone.setName(request.getName());
        Project project = projectService.getProjectById(request.getProjectId());
        mileStone.setProject(project);

        mileStoneRepository.save(mileStone);
        return mileStone;
    }

    @Override
    public void deleteMileStone(long id) {
        //마엘스톤이 삭제될때 마엘스톤을 가지고 있는 테스크들의 마엘스톤fk를 null로 만들어야함
        List<Task> taskByMilestoneId = taskRepository.findByMileStoneId(id);
        for (Task task : taskByMilestoneId) {
            task.setMileStone(null);
            taskRepository.save(task);
        }
        mileStoneRepository.deleteById(id);
    }


    @Override
    public List<MileStone> getAllMileStones() {
        return mileStoneRepository.findAll();
    }

    // 추가된내용!
    @Override public MileStone getMileStoneById(Long id) {
        return mileStoneRepository.findMileStoneById(id).orElseThrow( ()->
                new MileStoneNullPointException("해당 아이디의 mileStone이 존재하지 않습니다"));
    }

}
