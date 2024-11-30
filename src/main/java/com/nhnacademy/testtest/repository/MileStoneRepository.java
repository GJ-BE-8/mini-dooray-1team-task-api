package com.nhnacademy.testtest.repository;

import com.nhnacademy.testtest.dto.milestone.MileStoneDto;
import com.nhnacademy.testtest.entity.MileStone;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MileStoneRepository extends JpaRepository<MileStone, Long> {

    @Query("select new com.nhnacademy.testtest.dto.milestone.MileStoneDto(m.name) from MileStone m")
    List<MileStoneDto> findAllBy();

    Optional<MileStone> findMileStoneById(long id);
}
