package com.i2e.baselineapp.controller;

import com.i2e.baselineapp.dto.BaselineDTO;
import com.i2e.baselineapp.service.BaselineService;
import com.i2e.baselineapp.service.BaselineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by anirudh on 11/24/15.
 */

@Controller
public class BaselineController {

    @Autowired
    BaselineService baselineService;

    @RequestMapping("/baselines")
    public ResponseEntity<List<BaselineDTO>> getAllBaselines(){

        return new ResponseEntity<List<BaselineDTO>>(baselineService.getBaselineDTO(),
                HttpStatus.OK);

    }


}
