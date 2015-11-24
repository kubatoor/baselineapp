package com.i2e.baselineapp.model;

import java.util.Date;

/**
 * Created by ankur on 11/23/2015.
 */
public class ProdBaseline {
    private String appName;
    private String baseline;
    private Date date;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getBaseline() {
        return baseline;
    }

    public void setBaseline(String baseline) {
        this.baseline = baseline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
