package com.i2e.baselineapp.controller;

import com.i2e.baselineapp.dto.ReleaseManagementDTO;
import com.i2e.baselineapp.service.ReleaseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by anirudh on 11/24/15.
 */
@Controller
public class ReleaseManagementController {

    @Autowired
    private ReleaseManagementService releaseManagementService;

    @RequestMapping("/releasemanagement")
    public ResponseEntity<ReleaseManagementDTO> getAllReleases(){

        ReleaseManagementDTO releaseManagementDTOs = releaseManagementService.getAllReleases();

        return new ResponseEntity<ReleaseManagementDTO>(releaseManagementDTOs, HttpStatus.OK);


    }
}
