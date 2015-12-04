package com.i2e.baselineapp.service;

import com.i2e.baselineapp.dto.ReleaseManagementDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by anirudh on 11/24/15.
 */

public interface ReleaseManagementService {


    public ReleaseManagementDTO getAllReleases();
}
