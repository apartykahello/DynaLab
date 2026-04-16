package com.visa.dynalab.controller;

import com.visa.dynalab.dto.DynamicModel.CreateDynamicModelDto;
import com.visa.dynalab.dto.DynamicModel.DynamicModelDto;
import com.visa.dynalab.dto.DynamicModel.UpdateDynamicModelDto;
import com.visa.dynalab.service.DynamicModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class DynamicModelController {

    private final DynamicModelService dynamicModelService;

    public DynamicModelController(DynamicModelService dynamicModelService) {
        this.dynamicModelService = dynamicModelService;
    }

    @PostMapping
    public ResponseEntity<DynamicModelDto> create(@RequestBody CreateDynamicModelDto request) {
        return ResponseEntity.ok(dynamicModelService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<DynamicModelDto>> getAll() {
        return ResponseEntity.ok(dynamicModelService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DynamicModelDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dynamicModelService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DynamicModelDto> update(@PathVariable Long id,
                                                  @RequestBody UpdateDynamicModelDto request) {
        return ResponseEntity.ok(dynamicModelService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dynamicModelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}