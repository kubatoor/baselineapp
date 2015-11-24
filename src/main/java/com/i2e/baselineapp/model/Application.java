package com.i2e.baselineapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private Set<Baseline> baselines;
    private Project project;
    private String earName;
    private String webModuleName;

    public String getEarName() {
        return earName;
    }

    public void setEarName(String earName) {
        this.earName = earName;
    }

    public String getWebModuleName() {
        return webModuleName;
    }

    public void setWebModuleName(String webModuleName) {
        this.webModuleName = webModuleName;
    }

    public String getvHostMapping() {
        return vHostMapping;
    }

    public void setvHostMapping(String vHostMapping) {
        this.vHostMapping = vHostMapping;
    }

    private String vHostMapping;


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
    public Set<Baseline> getBaselines() {
        return baselines;
    }

    public void setBaselines(Set<Baseline> baselines) {
        this.baselines = baselines;
    }
    @ManyToOne
    @JoinColumn(name = "project_id")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
