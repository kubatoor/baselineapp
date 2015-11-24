package com.i2e.baselineapp.service;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.i2e.baselineapp.dto.BaselineDTO;
import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.Baseline;
import com.i2e.baselineapp.repository.BaseLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anirudh on 11/24/15.
 */
@Component
public class BaselineServiceImpl implements BaselineService {

    @Autowired
    private BaseLineRepository baseLineRepository;

    @Override
    public List<BaselineDTO> getBaselineDTO() {

        List<Baseline> baselines = baseLineRepository.findAll();
        List<BaselineDTO> baselineDTOs = new ArrayList<BaselineDTO>();
        for(Baseline baseline : baselines){

            String baseLineName = baseline.getBaselineName();
            Application application = baseline.getApplication();
            String applicationName = application.getApplicationName();
            String jvmName = application.getJvmName();
            String releaseDate = baseline.getBaselineDate();
            BaselineDTO baseLineDTO = new BaselineDTO();
            baseLineDTO.setBaselineName(baseLineName);
            baseLineDTO.setApplicationName(applicationName);
            baseLineDTO.setJvmName(jvmName);
            baseLineDTO.setReleaseDate(releaseDate);
            baselineDTOs.add(baseLineDTO);
        }

        return baselineDTOs;

    }
}
