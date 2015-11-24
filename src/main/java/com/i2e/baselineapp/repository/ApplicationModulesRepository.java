/**
 * 
 */
package com.i2e.baselineapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.i2e.baselineapp.model.ApplicationModule;

/**
 * @author ptalele
 *
 */
@Repository
public interface ApplicationModulesRepository extends CrudRepository<ApplicationModule, Long> {

	ApplicationModule findByApplicationId(long applicationId);
	List<ApplicationModule> findAll();
}
