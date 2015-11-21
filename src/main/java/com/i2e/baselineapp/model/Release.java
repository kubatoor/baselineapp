package com.i2e.baselineapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by anirudh on 11/21/15.
 */

@Entity
@Table(name = "release_table")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="release_id")
    public Long getReleaseID() { return releaseID; }

    public void setReleaseID(Long releaseID) {
        this.releaseID = releaseID;
    }

    @Column(name="release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "release_coordinator")
    public String getReleaseCoordinator() {
        return releaseCoordinator;
    }

    public void setReleaseCoordinator(String releaseCoordinator) {
        this.releaseCoordinator = releaseCoordinator;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="release_project", joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    private Long releaseID;
    private Date releaseDate;
    private String releaseCoordinator;
    private Set<Project> projects;
}
