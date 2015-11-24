/**
 * 
 */
package com.i2e.baselineapp.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.ApplicationModule;

/**
 * @author ptalele
 * This is test class
 */
@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = ApplicationModulesRepositoryTest.class)
@WebAppConfiguration
public class ApplicationModulesRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(ApplicationModulesRepositoryTest.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationModulesRepositoryTest.class);
	}

	@Test
	public CommandLineRunner demo(ApplicationModulesRepository repository) {
		return (args) -> {
			Set<ApplicationModule> modules = new HashSet<ApplicationModule>();
			ApplicationModule module = new ApplicationModule("LoginRegWeb", "iBank-sec-virtualhost", new Application());
			modules.add(module);

			// Application application = new Application("BankLoginregApp",
			// "iBankLoginregJVM", "InternetCMS1",
			// "/tmp/build/loginreg_app",modules);

			// save a couple of customers
			repository.save(new ApplicationModule("LoginRegWeb", "iBank-sec-virtualhost", new Application()));

			// fetch all customers
			log.info("ApplicationModule found with findAll():");
			log.info("-------------------------------");
			long applicationId = 1L;
			for (ApplicationModule appModule : repository.findAll()) {
				log.info(appModule.toString());
				applicationId = appModule.getApplication().getApplicationID();
			}
			log.info("");

			// fetch an individual customer by ID
			ApplicationModule appModule = repository.findByApplicationId(applicationId);
			log.info("ApplicationModule found with findByApplicationId(applicationId):");
			log.info("--------------------------------");
			log.info(appModule.toString());
			log.info("");

		};
	}

}
