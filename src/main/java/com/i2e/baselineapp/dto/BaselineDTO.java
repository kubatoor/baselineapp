package com.i2e.baselineapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anirudh on 11/24/15.
 */
public class BaselineDTO {

    @JsonProperty("APPNAME")
    public String applicationName;
    @JsonProperty("JVM")
    public String jvmName;
    @JsonProperty("BASELINE")
    public String baselineName;
    @JsonProperty("RELEASEDATE")
    public String releaseDate;

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

    public String getBaselineName() {
        return baselineName;
    }

    public void setBaselineName(String baselineName) {
        this.baselineName = baselineName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


}

