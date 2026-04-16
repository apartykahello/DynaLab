package com.visa.dynalab.repository;

import com.visa.dynalab.entity.DynamicModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DynamicModelRepository extends JpaRepository<DynamicModel, Long> {

    List<DynamicModel> findByNameContainingIgnoreCase(String name);
}