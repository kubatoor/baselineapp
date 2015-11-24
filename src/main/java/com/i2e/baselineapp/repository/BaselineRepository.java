package com.i2e.baselineapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.i2e.baselineapp.model.Baseline;

@Repository
public interface BaselineRepository extends CrudRepository<Baseline,Long> {


    public List<Baseline> findByApplicationId(String applicationId);

    public List<Baseline> findAll();
    
    public List<Baseline> findByBaselineId(String baselineId);
}
