package com.visa.dynalab.repository;

import com.visa.dynalab.entity.SimulationResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulationResultRepository extends JpaRepository<SimulationResult, Long> {

    List<SimulationResult> findBySimulationId(Long simulationId);

    List<SimulationResult> findBySimulationIdOrderByInitialConditionIdAscStepIndexAsc(Long simulationId);

    List<SimulationResult> findByInitialConditionIdOrderByStepIndexAsc(Long initialConditionId);

    void deleteBySimulationId(Long simulationId);
}