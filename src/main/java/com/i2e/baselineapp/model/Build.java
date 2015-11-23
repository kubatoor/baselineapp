package com.i2e.baselineapp.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumns;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by anirudh on 11/21/15.
 */
@Entity
@Table(name = "BUILD_TABLE")
public class Build {

    private Long buildID;
    private String buildLink;
    private String baselineName;
    private Application application;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBuildID() {
        return buildID;
    }

    public void setBuildID(Long buildID) {
        this.buildID = buildID;
    }

    public String getBuildLink() {
        return buildLink;
    }

    public void setBuildLink(String buildLink) {
        this.buildLink = buildLink;
    }

    public String getBaselineName() {
        return baselineName;
    }

    public void setBaselineName(String baselineName) {
        this.baselineName = baselineName;
    }

    @ManyToOne
    @JoinColumn(name = "application_id")
    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }



}
