package com.i2e.baselineapp.controller;

import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anirudh on 11/22/15.
 */
@RestController

public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @RequestMapping("/hello")
    public String getApplication(){

        return "hello";

       // return applicationRepository.findByApplicationName("testapp");

    }
}
