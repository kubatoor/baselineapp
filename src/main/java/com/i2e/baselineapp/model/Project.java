package com.i2e.baselineapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by anirudh on 11/21/15.
 */

@Entity
@Table(name = "PROJECT_TABLE")
public class Project {

    private Long projectID;
    private String projectName;
    private String contactPerson;
    @JsonIgnore
    private Set<Release> releases;
    private Set<Application> applications;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    public Long getProjectID() {
        return projectID;
    }

    public Project setProjectID(Long projectID) {
        this.projectID = projectID;
        return this;
    }

    @Column(name = "project_name")
    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    @Column(name = "contact_person")
    public String getContactPerson() {
        return contactPerson;
    }

    public Project setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "projects")
    public Set<Release> getReleases() {
        return releases;
    }

    public Project setReleases(Set<Release> releases) {
        this.releases = releases;
        return this;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

}
