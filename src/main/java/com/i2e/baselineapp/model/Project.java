package com.i2e.baselineapp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by anirudh on 11/21/15.
 */

@Entity
public class Project {

    private Long projectID;
    private String projectName;
    private String contactPerson;
    private Set<Release> releases;

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
}
