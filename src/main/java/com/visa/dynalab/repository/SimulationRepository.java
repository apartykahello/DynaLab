package com.visa.dynalab.repository;

import com.visa.dynalab.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulationRepository extends JpaRepository<Simulation, Long> {

    List<Simulation> findByUserId(Long userId);

    List<Simulation> findByDynamicModelId(Long dynamicModelId);

    List<Simulation> findByStatus(String status);

    List<Simulation> findByUserIdAndStatus(Long userId, String status);
}