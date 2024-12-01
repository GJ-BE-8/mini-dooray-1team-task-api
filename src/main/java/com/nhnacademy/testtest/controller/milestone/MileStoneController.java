package com.nhnacademy.testtest.controller.milestone;

import com.nhnacademy.testtest.dto.milestone.MileStonePostRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneModifyRequest;
import com.nhnacademy.testtest.entity.MileStone;
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
    public ResponseEntity<MileStone> createMileStone(@RequestBody MileStonePostRequest request) {
        mileStoneService.createMileStone(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{mileStoneId}")
    public ResponseEntity<MileStone> getMileStoneById(@PathVariable Long mileStoneId){
        MileStone mileStone = mileStoneService.getMileStoneById(mileStoneId);
        return ResponseEntity.ok(mileStone);

    }

    @GetMapping
    public List<MileStone> getAllMileStones() {
        return mileStoneService.getAllMileStones();
    }

    @PutMapping
    public ResponseEntity<MileStone> updateMileStone(@RequestBody MileStoneModifyRequest modifyMileStoneRequest) {
        MileStone mileStone = mileStoneService.updateMileStone(modifyMileStoneRequest);
        return ResponseEntity.ok(mileStone);
    }

    @DeleteMapping("/{mileStoneId}")
    public ResponseEntity<MileStone> deleteMileStone(@PathVariable Long mileStoneId) {
        mileStoneService.deleteMileStone(mileStoneId);
        return ResponseEntity.ok().build();
    }

}
