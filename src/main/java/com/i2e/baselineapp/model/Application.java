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
    private String cellName;
    private String artifactName;
    private String ejbModule;
    private String webModule;
    private String vHostMapping;
    private String prodBaseline;
    private Set<Build> builds;
    private Project project;


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

    @Column(name = "artifact_name")
    public String getArtifactName() {
        return artifactName;
    }

    public Application setArtifactName(String artifactName) {
        this.artifactName = artifactName;
        return this;
    }

    @Column(name = "ejb_module")
    public String getEjbModule() {
        return ejbModule;
    }

    public Application setEjbModule(String ejbModule) {
        this.ejbModule = ejbModule;
        return this;
    }

    @Column(name = "web_module")
    public String getWebModule() {
        return webModule;
    }

    public Application setWebModule(String webModule) {
        this.webModule = webModule;
        return this;
    }

    @Column(name = "vhost_mapping")
    public String getvHostMapping() {
        return vHostMapping;
    }

    public Application setvHostMapping(String vHostMapping) {
        this.vHostMapping = vHostMapping;
        return this;
    }

    @Column(name = "prod_baseline")
    public String getProdBaseline() {
        return prodBaseline;
    }

    public Application setProdBaseline(String prodBaseline) {
        this.prodBaseline = prodBaseline;
        return this;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
    public Set<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(Set<Build> builds) {
        this.builds = builds;
    }

    @ManyToOne
    @JoinColumn(name="application_id")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }












}
