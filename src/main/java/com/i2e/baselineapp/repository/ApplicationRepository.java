package com.i2e.baselineapp.repository;

import com.i2e.baselineapp.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anirudh on 11/22/15.
 */

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long>{

    public Application findByApplicationName(String applicationName);

    public List<Application> findAll();
   }

