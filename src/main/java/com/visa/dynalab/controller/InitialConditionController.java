package com.visa.dynalab.controller;

import com.visa.dynalab.dto.Simulation.InitialConditionDto;
import com.visa.dynalab.service.InitialConditionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulations/{simulationId}/initial-conditions")
public class InitialConditionController {

    private final InitialConditionService initialConditionService;

    public InitialConditionController(InitialConditionService initialConditionService) {
        this.initialConditionService = initialConditionService;
    }

    @PostMapping
    public ResponseEntity<InitialConditionDto> create(@PathVariable Long simulationId,
                                                      @RequestBody InitialConditionDto request) {
        return ResponseEntity.ok(initialConditionService.create(simulationId, request));
    }

    @GetMapping
    public ResponseEntity<List<InitialConditionDto>> getAll(@PathVariable Long simulationId) {
        return ResponseEntity.ok(initialConditionService.getAllBySimulationId(simulationId));
    }

    @GetMapping("/{initialConditionId}")
    public ResponseEntity<InitialConditionDto> getById(@PathVariable Long simulationId,
                                                       @PathVariable Long initialConditionId) {
        return ResponseEntity.ok(initialConditionService.getById(simulationId, initialConditionId));
    }

    @PutMapping("/{initialConditionId}")
    public ResponseEntity<InitialConditionDto> update(@PathVariable Long simulationId,
                                                      @PathVariable Long initialConditionId,
                                                      @RequestBody InitialConditionDto request) {
        return ResponseEntity.ok(initialConditionService.update(simulationId, initialConditionId, request));
    }

    @DeleteMapping("/{initialConditionId}")
    public ResponseEntity<Void> delete(@PathVariable Long simulationId,
                                       @PathVariable Long initialConditionId) {
        initialConditionService.delete(simulationId, initialConditionId);
        return ResponseEntity.noContent().build();
    }
}