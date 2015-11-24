package com.i2e.baselineapp.controller;

import com.i2e.baselineapp.model.Release;
import com.i2e.baselineapp.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anirudh on 11/23/15.
 */

@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    ReleaseRepository releaseRepository;


    @RequestMapping("/releases")
    public ResponseEntity getAllReleases(){

        List<Release> releases = releaseRepository.findAll();

        return new ResponseEntity<List<Release>>(releases, HttpStatus.OK);

    }

    @RequestMapping("{date}")
    public ResponseEntity<List<Release>> getReleaseByDate(@PathVariable("date") String date){

        List<Release> releases = releaseRepository.findByReleaseDate(date);
        return new ResponseEntity<List<Release>>(releases, HttpStatus.OK);

    }

    @RequestMapping(value="/add" , method = RequestMethod.POST)
    public void addRelease(@RequestBody Release release){
        releaseRepository.save(release);

    }


}
