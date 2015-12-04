package com.i2e.baselineapp.dto;

import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.Project;

import java.util.List;
import java.util.Map;

/**
 * Created by anirudh on 11/24/15.
 */
public class ReleaseManagementDTO {


    public Map<String, List<ProjectDTO>> getProjects() {
        return projects;
    }

    public void setProjects(Map<String, List<ProjectDTO>> projects) {
        this.projects = projects;
    }

    private Map<String,List<ProjectDTO>> projects;


    
}
