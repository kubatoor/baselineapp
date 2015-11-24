/**
 * 
 */
package com.i2e.baselineapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.i2e.baselineapp.model.Project;

/**
 * @author ptalele
 *
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
  Project findByProjectid(String ProjectId);
  Project findByProjectName(String ProjectName);
  List<Project> findByReleaseId(String releaseId);
  List<Project> findByAnalystName(String analystName);
  
}
