package com.i2e.baselineapp.controller;

import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.Release;
import com.i2e.baselineapp.repository.ApplicationRepository;
import com.i2e.baselineapp.util.BaseLineExcelGenerator;
import com.i2e.baselineapp.util.ChangeLogReader;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by anirudh on 11/22/15.
 */
@RestController

public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @RequestMapping("/hello")
    public ResponseEntity<Application> getApplication(){
        Application application = applicationRepository.findByApplicationName("strongauth");
        return new ResponseEntity<Application>(application, HttpStatus.OK);

       // return applicationRepository.findByApplicationName("testapp");

    }

    @RequestMapping("/loadchangelog")
    public ResponseEntity<List<Release>> loadChangeLog(HttpServletRequest request){
        List<Release> releases = ChangeLogReader.getReleases();
        return new ResponseEntity<List<Release>>(releases, HttpStatus.OK);
    }


    @RequestMapping("/genbaseline")
    public void generateBaselineSheet(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Release> releases = ChangeLogReader.getReleases();
            Workbook wb = BaseLineExcelGenerator.getInstance().generateBaseLine(releases);
            OutputStream out = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=BASELINES_IHS WAS8_Consumer_Cell.xls");
            wb.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
