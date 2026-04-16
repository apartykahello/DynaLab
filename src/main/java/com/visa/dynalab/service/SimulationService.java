package com.visa.dynalab.service;

import com.visa.dynalab.dto.Simulation.CreateSimulationDto;
import com.visa.dynalab.dto.Simulation.InitialConditionDto;
import com.visa.dynalab.dto.Simulation.SimulationDto;
import com.visa.dynalab.dto.Simulation.UpdateSimulationDto;
import com.visa.dynalab.entity.DynamicModel;
import com.visa.dynalab.entity.Simulation;
import com.visa.dynalab.entity.User;
import com.visa.dynalab.repository.DynamicModelRepository;
import com.visa.dynalab.repository.SimulationRepository;
import com.visa.dynalab.repository.SimulationResultRepository;
import com.visa.dynalab.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SimulationService {

    private final SimulationRepository simulationRepository;
    private final DynamicModelRepository dynamicModelRepository;
    private final UserRepository userRepository;
    private final SimulationResultRepository simulationResultRepository;

    public SimulationService(SimulationRepository simulationRepository,
                             DynamicModelRepository dynamicModelRepository,
                             UserRepository userRepository,
                             SimulationResultRepository simulationResultRepository) {
        this.simulationRepository = simulationRepository;
        this.dynamicModelRepository = dynamicModelRepository;
        this.userRepository = userRepository;
        this.simulationResultRepository = simulationResultRepository;
    }

    public SimulationDto create(CreateSimulationDto request, String userEmail) {
        DynamicModel dynamicModel = dynamicModelRepository.findById(request.getDynamicModelId())
                .orElseThrow(() -> new RuntimeException("Dynamic model not found"));

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Simulation simulation = new Simulation();
        simulation.setName(request.getName());
        simulation.setDt(request.getDt());
        simulation.setStepsCount(request.getStepsCount());
        simulation.setStatus(request.getStatus());
        simulation.setCreatedAt(LocalDateTime.now());
        simulation.setDynamicModel(dynamicModel);
        simulation.setUser(user);

        Simulation savedSimulation = simulationRepository.save(simulation);
        return mapToDto(savedSimulation);
    }

    public List<SimulationDto> getAll() {
        return simulationRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public List<SimulationDto> getAllByUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return simulationRepository.findByUserId(user.getId())
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public SimulationDto getById(Long id) {
        Simulation simulation = simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        return mapToDto(simulation);
    }

    public SimulationDto update(Long id, UpdateSimulationDto request) {
        Simulation simulation = simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        DynamicModel dynamicModel = dynamicModelRepository.findById(request.getDynamicModelId())
                .orElseThrow(() -> new RuntimeException("Dynamic model not found"));

        simulation.setName(request.getName());
        simulation.setDt(request.getDt());
        simulation.setStepsCount(request.getStepsCount());
        simulation.setStatus(request.getStatus());
        simulation.setDynamicModel(dynamicModel);

        simulationResultRepository.deleteBySimulationId(simulation.getId());

        Simulation updatedSimulation = simulationRepository.save(simulation);
        return mapToDto(updatedSimulation);
    }

    public void delete(Long id) {
        Simulation simulation = simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        simulationRepository.delete(simulation);
    }

    private SimulationDto mapToDto(Simulation simulation) {
        List<InitialConditionDto> initialConditionDtos = simulation.getInitialConditions()
                .stream()
                .map(ic -> new InitialConditionDto(
                        ic.getId(),
                        ic.getX0(),
                        ic.getY0()
                ))
                .toList();

        return new SimulationDto(
                simulation.getId(),
                simulation.getName(),
                simulation.getDt(),
                simulation.getStepsCount(),
                simulation.getStatus(),
                simulation.getCreatedAt(),
                simulation.getDynamicModel().getId(),
                simulation.getUser().getId(),
                initialConditionDtos
        );
    }
}