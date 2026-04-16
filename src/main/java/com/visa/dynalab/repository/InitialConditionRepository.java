package com.visa.dynalab.repository;

import com.visa.dynalab.entity.InitialCondition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InitialConditionRepository extends JpaRepository<InitialCondition, Long> {

    List<InitialCondition> findBySimulationId(Long simulationId);

    Optional<InitialCondition> findByIdAndSimulationId(Long id, Long simulationId);
}