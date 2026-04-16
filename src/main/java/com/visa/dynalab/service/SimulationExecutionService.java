package com.visa.dynalab.service;

import com.visa.dynalab.dto.Simulation.InitialConditionResultsDto;
import com.visa.dynalab.dto.Simulation.SimulationResultDto;
import com.visa.dynalab.entity.DynamicModel;
import com.visa.dynalab.entity.InitialCondition;
import com.visa.dynalab.entity.Simulation;
import com.visa.dynalab.entity.SimulationResult;
import com.visa.dynalab.repository.InitialConditionRepository;
import com.visa.dynalab.repository.SimulationRepository;
import com.visa.dynalab.repository.SimulationResultRepository;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationExecutionService {

    private final SimulationRepository simulationRepository;
    private final SimulationResultRepository simulationResultRepository;
    private final InitialConditionRepository initialConditionRepository;

    public SimulationExecutionService(SimulationRepository simulationRepository,
                                      SimulationResultRepository simulationResultRepository,
                                      InitialConditionRepository initialConditionRepository) {
        this.simulationRepository = simulationRepository;
        this.simulationResultRepository = simulationResultRepository;
        this.initialConditionRepository = initialConditionRepository;
    }

    @Transactional
    public List<InitialConditionResultsDto> runSimulation(Long simulationId) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        if (simulation.getInitialConditions() == null || simulation.getInitialConditions().isEmpty()) {
            throw new RuntimeException("Simulation has no initial conditions");
        }

        DynamicModel model = simulation.getDynamicModel();
        String xExpressionText = model.getXExpression();
        String yExpressionText = model.getYExpression();

        Double dt = simulation.getDt();
        Integer stepsCount = simulation.getStepsCount();

        simulationResultRepository.deleteBySimulationId(simulationId);

        List<SimulationResult> allResults = new ArrayList<>();

        for (InitialCondition initialCondition : simulation.getInitialConditions()) {
            double t = 0.0;
            double x = initialCondition.getX0();
            double y = initialCondition.getY0();

            allResults.add(buildResult(simulation, initialCondition, 0, t, x, y));

            for (int step = 1; step <= stepsCount; step++) {
                double dx = evaluateExpression(xExpressionText, x, y);
                double dy = evaluateExpression(yExpressionText, x, y);

                double nextX = x + dt * dx;
                double nextY = y + dt * dy;
                double nextT = t + dt;

                allResults.add(buildResult(simulation, initialCondition, step, nextT, nextX, nextY));

                x = nextX;
                y = nextY;
                t = nextT;
            }
        }

        simulationResultRepository.saveAll(allResults);
        simulation.setStatus("COMPLETED");

        return getGroupedResults(simulationId);
    }

    public List<InitialConditionResultsDto> getGroupedResults(Long simulationId) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));

        List<InitialCondition> initialConditions = initialConditionRepository.findBySimulationId(simulationId);

        List<InitialConditionResultsDto> response = new ArrayList<>();

        for (InitialCondition initialCondition : initialConditions) {
            List<SimulationResultDto> results = simulationResultRepository
                    .findByInitialConditionIdOrderByStepIndexAsc(initialCondition.getId())
                    .stream()
                    .map(this::mapToDto)
                    .toList();

            response.add(new InitialConditionResultsDto(
                    initialCondition.getId(),
                    initialCondition.getX0(),
                    initialCondition.getY0(),
                    results
            ));
        }

        return response;
    }

    public List<SimulationResultDto> getResultsForInitialCondition(Long simulationId, Long initialConditionId) {
        InitialCondition initialCondition = initialConditionRepository
                .findByIdAndSimulationId(initialConditionId, simulationId)
                .orElseThrow(() -> new RuntimeException("Initial condition not found"));

        return simulationResultRepository.findByInitialConditionIdOrderByStepIndexAsc(initialCondition.getId())
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private double evaluateExpression(String expressionText, double x, double y) {
        try {
            Expression expression = new ExpressionBuilder(expressionText)
                    .variables("x", "y")
                    .build()
                    .setVariable("x", x)
                    .setVariable("y", y);

            return expression.evaluate();
        } catch (Exception e) {
            throw new RuntimeException("Invalid model expression: " + expressionText);
        }
    }

    private SimulationResult buildResult(Simulation simulation,
                                         InitialCondition initialCondition,
                                         int stepIndex,
                                         double time,
                                         double xValue,
                                         double yValue) {
        SimulationResult result = new SimulationResult();
        result.setSimulation(simulation);
        result.setInitialCondition(initialCondition);
        result.setStepIndex(stepIndex);
        result.setTime(time);
        result.setXValue(xValue);
        result.setYValue(yValue);
        return result;
    }

    private SimulationResultDto mapToDto(SimulationResult result) {
        return new SimulationResultDto(
                result.getId(),
                result.getTime(),
                result.getXValue(),
                result.getYValue(),
                result.getStepIndex(),
                result.getInitialCondition().getId()
        );
    }
}