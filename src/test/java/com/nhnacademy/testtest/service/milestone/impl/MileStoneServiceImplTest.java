package com.nhnacademy.testtest.service.milestone.impl;

import com.nhnacademy.testtest.dto.milestone.MileStonePostRequest;
import com.nhnacademy.testtest.dto.milestone.MileStoneModifyRequest;
import com.nhnacademy.testtest.entity.MileStone;
import com.nhnacademy.testtest.entity.Project;
import com.nhnacademy.testtest.entity.Task;
import com.nhnacademy.testtest.exception.MileStoneNullPointException;
import com.nhnacademy.testtest.repository.MileStoneRepository;
import com.nhnacademy.testtest.repository.TaskRepository;
import com.nhnacademy.testtest.service.project.ProjectService;
import com.nhnacademy.testtest.service.milestone.MileStoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MileStoneServiceImplTest {

    @Mock
    private MileStoneRepository mileStoneRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private MileStoneServiceImpl mileStoneService;

    private MileStone mileStone;
    private Project project;

    @BeforeEach
    void setUp() {
        project = new Project();
        project.setId(1L);
        project.setName("Test Project");

        mileStone = new MileStone("Test MileStone", project);
        mileStone.setId(1L);
    }

    @Test
    public void testCreateMileStone() {
        // given
        Long milestoneId = 1L;    // 마일스톤 ID
        String name = "마일스톤 이름"; // 마일스톤 이름
        Long projectId = 2L;      // 프로젝트 ID

        // MileStonePostRequest 객체 생성
        MileStonePostRequest request = new MileStonePostRequest(milestoneId, name, projectId);

        // when
        MileStone mileStone = mileStoneService.createMileStone(request);

        // then
        assertNotNull(mileStone);
        assertEquals(name, mileStone.getName());
    }


    @Test
    void testUpdateMileStone() {
        MileStoneModifyRequest request = new MileStoneModifyRequest(1L, "Updated MileStone", 1L);

        when(mileStoneRepository.findById(1L)).thenReturn(Optional.of(mileStone));
        when(projectService.getProjectById(1L)).thenReturn(project);
        when(mileStoneRepository.save(any(MileStone.class))).thenReturn(mileStone);

        MileStone updatedMileStone = mileStoneService.updateMileStone(request);

        assertNotNull(updatedMileStone);
        assertEquals("Updated MileStone", updatedMileStone.getName());
        assertEquals(1L, updatedMileStone.getProject().getId());
        verify(mileStoneRepository, times(1)).save(any(MileStone.class));
    }

    @Test
    void testUpdateMileStoneWhenNotFound() {
        MileStoneModifyRequest request = new MileStoneModifyRequest(999L, "NonExisting MileStone", 1L);

        when(mileStoneRepository.findById(999L)).thenReturn(Optional.empty());

        MileStoneNullPointException exception = assertThrows(MileStoneNullPointException.class, () -> {
            mileStoneService.updateMileStone(request);
        });

        assertEquals("해당 아이디의 mileStone이 존재하지 않습니다", exception.getMessage());
    }

    @Test
    void testDeleteMileStone() {
        when(taskRepository.findByMileStoneId(1L)).thenReturn(Arrays.asList(new Task()));
        doNothing().when(mileStoneRepository).deleteById(1L);

        mileStoneService.deleteMileStone(1L);

        verify(taskRepository, times(1)).findByMileStoneId(1L);
        verify(mileStoneRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAllMileStones() {
        when(mileStoneRepository.findAll()).thenReturn(Arrays.asList(mileStone));

        List<MileStone> mileStones = mileStoneService.getAllMileStones();

        assertNotNull(mileStones);
        assertEquals(1, mileStones.size());
        assertEquals("Test MileStone", mileStones.get(0).getName());
    }

    @Test
    void testGetMileStoneById() {
        when(mileStoneRepository.findMileStoneById(1L)).thenReturn(Optional.of(mileStone));

        MileStone foundMileStone = mileStoneService.getMileStoneById(1L);

        assertNotNull(foundMileStone);
        assertEquals(1L, foundMileStone.getId());
        assertEquals("Test MileStone", foundMileStone.getName());
    }

    @Test
    void testGetMileStoneByIdWhenNotFound() {
        when(mileStoneRepository.findMileStoneById(999L)).thenReturn(Optional.empty());

        MileStoneNullPointException exception = assertThrows(MileStoneNullPointException.class, () -> {
            mileStoneService.getMileStoneById(999L);
        });

        assertEquals("해당 아이디의 mileStone이 존재하지 않습니다", exception.getMessage());
    }
}
