package com.nhnacademy.testtest.controller.milestone;

import com.nhnacademy.testtest.dto.milestone.CreateMileStoneRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneDto;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import com.nhnacademy.testtest.service.project.ProjectService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/milestone")
public class MileStoneController {

    private final MileStoneService mileStoneService;
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<MileStone> createMileStone(@RequestBody CreateMileStoneRequest request, @RequestParam Long projectId) {
        Project project = projectService.getProjectById(projectId).orElse(null);
        MileStone mileStone = mileStoneService.createMileStone(request, project);
        return ResponseEntity.ok(mileStone);
    }

    @GetMapping
    public ResponseEntity<List<MileStoneDto>> getAllMileStones() {
        List<MileStoneDto> allMileStones = mileStoneService.getAllMileStones();
        return ResponseEntity.ok(allMileStones);
    }

}