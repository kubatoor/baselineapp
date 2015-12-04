package com.i2e.baselineapp.dto;

import com.i2e.baselineapp.model.Baseline;
import com.i2e.baselineapp.model.Project;

import java.util.Set;

/**
 * Created by anirudh on 11/24/15.
 */
public class ApplicationDTO {

    private String applicationName;
    private String jvmName;
    private String cellName;
    private String buildPath;
    private Project project;
    private String earName;
    private String webModuleName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getBuildPath() {
        return buildPath;
    }

    public void setBuildPath(String buildPath) {
        this.buildPath = buildPath;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

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



}

