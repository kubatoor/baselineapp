package com.i2e.baselineapp.dto;

/**
 * Created by anirudh on 11/24/15.
 */
public class ReleaseManagementDTO_backup {

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    private String releaseName;
    private String projectName;
    private String applicationName;
    private String baseLineName;
    private String buildPath;
    private String jvmName;
    private String  earName;
    private String webModuleName;
    private String regenPlugin;
    private String cellName;
    private String vHostMapping;


    public String getBaseLineName() {
        return baseLineName;
    }

    public void setBaseLineName(String baseLineName) {
        this.baseLineName = baseLineName;
    }

    public String getBuildPath() {
        return buildPath;
    }

    public void setBuildPath(String buildPath) {
        this.buildPath = buildPath;
    }

    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
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

    public String getRegenPlugin() {
        return regenPlugin;
    }

    public void setRegenPlugin(String regenPlugin) {
        this.regenPlugin = regenPlugin;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getvHostMapping() {
        return vHostMapping;
    }

    public void setvHostMapping(String vHostMapping) {
        this.vHostMapping = vHostMapping;
    }



    
}
