package com.visa.dynalab.service;

import com.visa.dynalab.dto.Simulation.InitialConditionDto;
import com.visa.dynalab.entity.InitialCondition;
import com.visa.dynalab.entity.Simulation;
import com.visa.dynalab.repository.InitialConditionRepository;
import com.visa.dynalab.repository.SimulationRepository;
import com.visa.dynalab.repository.SimulationResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitialConditionService {

    private final InitialConditionRepository initialConditionRepository;
    private final SimulationRepository simulationRepository;
    private final SimulationResultRepository simulationResultRepository;

    public InitialConditionService(InitialConditionRepository initialConditionRepository,
                                   SimulationRepository simulationRepository,
                                   SimulationResultRepository simulationResultRepository) {
        this.initialConditionRepository = initialConditionRepository;
        this.simulationRepository = simulationRepository;
        this.simulationResultRepository = simulationResultRepository;
    }

    public InitialConditionDto create(Long simulationId, InitialConditionDto request) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        InitialCondition initialCondition = new InitialCondition();
        initialCondition.setX0(request.getX0());
        initialCondition.setY0(request.getY0());
        initialCondition.setSimulation(simulation);

        InitialCondition saved = initialConditionRepository.save(initialCondition);

        simulationResultRepository.deleteBySimulationId(simulationId);

        return mapToDto(saved);
    }

    public List<InitialConditionDto> getAllBySimulationId(Long simulationId) {
        simulationRepository.findById(simulationId)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        return initialConditionRepository.findBySimulationId(simulationId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public InitialConditionDto getById(Long simulationId, Long initialConditionId) {
        InitialCondition initialCondition = initialConditionRepository
                .findByIdAndSimulationId(initialConditionId, simulationId)
                .orElseThrow(() -> new RuntimeException("Initial condition not found"));

        return mapToDto(initialCondition);
    }

    public InitialConditionDto update(Long simulationId, Long initialConditionId, InitialConditionDto request) {
        InitialCondition initialCondition = initialConditionRepository
                .findByIdAndSimulationId(initialConditionId, simulationId)
                .orElseThrow(() -> new RuntimeException("Initial condition not found"));

        initialCondition.setX0(request.getX0());
        initialCondition.setY0(request.getY0());

        InitialCondition updated = initialConditionRepository.save(initialCondition);

        simulationResultRepository.deleteBySimulationId(simulationId);

        return mapToDto(updated);
    }

    public void delete(Long simulationId, Long initialConditionId) {
        InitialCondition initialCondition = initialConditionRepository
                .findByIdAndSimulationId(initialConditionId, simulationId)
                .orElseThrow(() -> new RuntimeException("Initial condition not found"));

        initialConditionRepository.delete(initialCondition);

        simulationResultRepository.deleteBySimulationId(simulationId);
    }

    private InitialConditionDto mapToDto(InitialCondition initialCondition) {
        return new InitialConditionDto(
                initialCondition.getId(),
                initialCondition.getX0(),
                initialCondition.getY0()
        );
    }
}