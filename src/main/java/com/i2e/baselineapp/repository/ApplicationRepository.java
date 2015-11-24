package com.i2e.baselineapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.i2e.baselineapp.model.Application;

/**
 * Created by anirudh on 11/22/15.
 */

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long>{

    public Application findByApplicationName(String applicationName);

    public Application findByEjbModule(String ejbModule);
    
    public List<Application> findByProjectName(String projectName);
}

