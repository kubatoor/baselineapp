package com.i2e.baselineapp.repository;

import com.i2e.baselineapp.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anirudh on 11/24/15.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {


    public List<Project> findAll();


}
