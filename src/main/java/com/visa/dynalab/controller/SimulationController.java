package com.visa.dynalab.controller;

import com.visa.dynalab.dto.Simulation.CreateSimulationDto;
import com.visa.dynalab.dto.Simulation.InitialConditionResultsDto;
import com.visa.dynalab.dto.Simulation.SimulationDto;
import com.visa.dynalab.dto.Simulation.SimulationResultDto;
import com.visa.dynalab.dto.Simulation.UpdateSimulationDto;
import com.visa.dynalab.service.SimulationExecutionService;
import com.visa.dynalab.service.SimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationController {

    private final SimulationService simulationService;
    private final SimulationExecutionService simulationExecutionService;

    public SimulationController(SimulationService simulationService,
                                SimulationExecutionService simulationExecutionService) {
        this.simulationService = simulationService;
        this.simulationExecutionService = simulationExecutionService;
    }

    @PostMapping
    public ResponseEntity<SimulationDto> create(@RequestBody CreateSimulationDto request,
                                                Authentication authentication) {
        return ResponseEntity.ok(
                simulationService.create(request, authentication.getName())
        );
    }

    @GetMapping
    public ResponseEntity<List<SimulationDto>> getAll() {
        return ResponseEntity.ok(simulationService.getAll());
    }

    @GetMapping("/my")
    public ResponseEntity<List<SimulationDto>> getMy(Authentication authentication) {
        return ResponseEntity.ok(
                simulationService.getAllByUser(authentication.getName())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulationDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(simulationService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimulationDto> update(@PathVariable Long id,
                                                @RequestBody UpdateSimulationDto request) {
        return ResponseEntity.ok(simulationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        simulationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/run")
    public ResponseEntity<List<InitialConditionResultsDto>> runSimulation(@PathVariable Long id) {
        return ResponseEntity.ok(simulationExecutionService.runSimulation(id));
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<List<InitialConditionResultsDto>> getResults(@PathVariable Long id) {
        return ResponseEntity.ok(simulationExecutionService.getGroupedResults(id));
    }

    @GetMapping("/{simulationId}/initial-conditions/{initialConditionId}/results")
    public ResponseEntity<List<SimulationResultDto>> getResultsForInitialCondition(
            @PathVariable Long simulationId,
            @PathVariable Long initialConditionId) {
        return ResponseEntity.ok(
                simulationExecutionService.getResultsForInitialCondition(simulationId, initialConditionId)
        );
    }
}