package com.nhnacademy.testtest.controller.milestone;

import com.nhnacademy.testtest.dto.milestone.CreateMileStoneRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneDto;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.exception.ProjectNullPointException;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import com.nhnacademy.testtest.service.project.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/milestone")
public class MileStoneController {

    private final MileStoneService mileStoneService;
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<MileStone> createMileStone(@RequestBody CreateMileStoneRequest request, @RequestParam Long projectId) {
        Project project = projectService.getProjectById(projectId).orElse(null);
        if(project == null) {
            throw new ProjectNullPointException("project is null");
        }
        MileStone mileStone = mileStoneService.createMileStone(request, projectId);
        return ResponseEntity.ok(mileStone);
    }

    @GetMapping("/{mileStoneId}")
    public MileStone getMileStoneById(@PathVariable Long mileStoneId){

        return mileStoneService.getMileStoneById(mileStoneId);

    }

    @GetMapping
    public ResponseEntity<List<MileStoneDto>> getAllMileStones() {
        List<MileStoneDto> allMileStones = mileStoneService.getAllMileStones();
        return ResponseEntity.ok(allMileStones);
    }

    @PutMapping
    public ResponseEntity<MileStone> updateMileStone(@RequestBody CreateMileStoneRequest createMileStoneRequest, @RequestParam Long milestoneId) {
        MileStone mileStone = mileStoneService.updateMileStone(createMileStoneRequest, milestoneId);
        return ResponseEntity.ok(mileStone);
    }

    @DeleteMapping
    public ResponseEntity<MileStone> deleteMileStone(@RequestParam Long milestoneId) {
        mileStoneService.deleteMileStone(milestoneId);
        return ResponseEntity.ok().build();
    }

}
