package com.i2e.baselineapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by anirudh on 11/21/15.
 */
@Entity
@Table(name = "APPLICATION_TABLE")
public class Application {

	private Long applicationID;
	private String applicationName;
	private String jvmName;
	private String cellName;
	private String buildPath;
	private Set<ApplicationModule> appModules;

	public Application() {
	};

	public Application(String applicationName, String jvmName, String cellName, String buildPath,
			Set<ApplicationModule> appModules) {
		this.applicationName = applicationName;
		this.jvmName = jvmName;
		this.cellName = cellName;
		this.buildPath = buildPath;
		this.appModules = appModules;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getApplicationID() {
		return applicationID;
	}

	public Application setApplicationID(Long applicationID) {
		this.applicationID = applicationID;
		return this;
	}

	@Column(name = "application_name")
	public String getApplicationName() {
		return applicationName;
	}

	public Application setApplicationName(String applicationName) {
		this.applicationName = applicationName;
		return this;
	}

	@Column(name = "cell_name")
	public String getCellName() {
		return cellName;
	}

	public Application setCellName(String cellName) {
		this.cellName = cellName;
		return this;
	}

	public String getJvmName() {
		return jvmName;
	}

	public void setJvmName(String jvmName) {
		this.jvmName = jvmName;
	}

	public String getBuildPath() {
		return buildPath;
	}

	public void setBuildPath(String buildPath) {
		this.buildPath = buildPath;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public Set<ApplicationModule> getAppModules() {
		return appModules;
	}

	public void setAppModules(Set<ApplicationModule> appModules) {
		this.appModules = appModules;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public Set<Baseline> getBaselines() {
		return baselines;
	}

	public void setBaselines(Set<Baseline> baselines) {
		this.baselines = baselines;
	}

	private Set<Baseline> baselines;

}
