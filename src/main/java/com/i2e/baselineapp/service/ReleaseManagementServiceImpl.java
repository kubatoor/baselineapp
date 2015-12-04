package com.i2e.baselineapp.service;

import com.i2e.baselineapp.dto.ApplicationDTO;
import com.i2e.baselineapp.dto.ProjectDTO;
import com.i2e.baselineapp.dto.ReleaseManagementDTO;
import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.Project;
import com.i2e.baselineapp.repository.ApplicationRepository;
import com.i2e.baselineapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by anirudh on 11/24/15.
 */
@Component
public class ReleaseManagementServiceImpl implements ReleaseManagementService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public ReleaseManagementDTO getAllReleases() {
        List<Project> projects = projectRepository.findAll();

        ReleaseManagementDTO releaseManagementDTO = new ReleaseManagementDTO();
        List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();
        Map<String, List<ProjectDTO>> projectListMap = new HashMap<String, List<ProjectDTO>>();

        for (Project project : projects) {

            String projectName = project.getProjectName();
            Set<Application> applications = project.getApplications();
            List<ApplicationDTO> applicationDTOs = new ArrayList<ApplicationDTO>();
            ProjectDTO projectDTO = new ProjectDTO();

            Map<String, List<ApplicationDTO>> applicationListMap = new HashMap<String, List<ApplicationDTO>>();
            String applicationName = null;

            for (Application application : applications) {


                ApplicationDTO applicationDTO = new ApplicationDTO();
                applicationName = application.getApplicationName();
                applicationDTO.setBuildPath(application.getBuildPath());
                applicationDTO.setCellName(application.getCellName());
                applicationDTO.setJvmName(application.getJvmName());
                applicationDTO.setEarName(application.getEarName());
                applicationDTOs.add(applicationDTO);

            }

            applicationListMap.put(applicationName, applicationDTOs);
            projectDTO.setApplications(applicationListMap);

        }

        return null;


    }
}