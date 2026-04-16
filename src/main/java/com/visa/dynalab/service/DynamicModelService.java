package com.visa.dynalab.service;

import com.visa.dynalab.dto.DynamicModel.CreateDynamicModelDto;
import com.visa.dynalab.dto.DynamicModel.DynamicModelDto;
import com.visa.dynalab.dto.DynamicModel.UpdateDynamicModelDto;
import com.visa.dynalab.entity.DynamicModel;
import com.visa.dynalab.repository.DynamicModelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DynamicModelService {

    private final DynamicModelRepository dynamicModelRepository;

    public DynamicModelService(DynamicModelRepository dynamicModelRepository) {
        this.dynamicModelRepository = dynamicModelRepository;
    }

    public DynamicModelDto create(CreateDynamicModelDto request) {
        DynamicModel model = new DynamicModel();
        model.setName(request.getName());
        model.setDescription(request.getDescription());
        model.setXExpression(request.getXExpression());
        model.setYExpression(request.getYExpression());
        model.setCreatedAt(LocalDateTime.now());
        model.setUpdatedAt(LocalDateTime.now());

        DynamicModel savedModel = dynamicModelRepository.save(model);
        return mapToDto(savedModel);
    }

    public List<DynamicModelDto> getAll() {
        return dynamicModelRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public DynamicModelDto getById(Long id) {
        DynamicModel model = dynamicModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        return mapToDto(model);
    }

    public DynamicModelDto update(Long id, UpdateDynamicModelDto request) {
        DynamicModel model = dynamicModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        model.setName(request.getName());
        model.setDescription(request.getDescription());
        model.setXExpression(request.getXExpression());
        model.setYExpression(request.getYExpression());
        model.setUpdatedAt(LocalDateTime.now());

        DynamicModel updatedModel = dynamicModelRepository.save(model);
        return mapToDto(updatedModel);
    }

    public void delete(Long id) {
        DynamicModel model = dynamicModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        dynamicModelRepository.delete(model);
    }

    private DynamicModelDto mapToDto(DynamicModel model) {
        return new DynamicModelDto(
                model.getId(),
                model.getName(),
                model.getDescription(),
                model.getXExpression(),
                model.getYExpression(),
                model.getCreatedAt(),
                model.getUpdatedAt()
        );
    }
}