package com.i2e.baselineapp.repository;

import com.i2e.baselineapp.model.Baseline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by anirudh on 11/24/15.
 */
public interface BaseLineRepository extends CrudRepository<Baseline, Long>{

    public List<Baseline> findAll();
}
