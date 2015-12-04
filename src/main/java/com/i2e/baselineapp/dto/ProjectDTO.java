package com.i2e.baselineapp.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by anirudh on 11/24/15.
 */
public class ProjectDTO {

    public Map<String, List<ApplicationDTO>> getApplications() {
        return applications;
    }

    public void setApplications(Map<String, List<ApplicationDTO>> applications) {
        this.applications = applications;
    }

    private Map<String,List<ApplicationDTO>> applications;
}
