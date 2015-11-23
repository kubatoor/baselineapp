package com.i2e.baselineapp.controller;

import com.i2e.baselineapp.model.Release;
import com.i2e.baselineapp.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by anirudh on 11/23/15.
 */

@RestController
@RequestMapping("/release")
public class ReleaseHistoryController {

    @Autowired
    ReleaseRepository releaseRepository;


    @RequestMapping("/releases")
    public ResponseEntity getAllReleases(){

        List<Release> releases = releaseRepository.findAll();

        return new ResponseEntity<List<Release>>(releases, HttpStatus.OK);

    }


}
