package com.i2e.baselineapp.model;

import javax.persistence.*;

/**
 * Created by anirudh on 11/23/15.
 */
public class ApplicationModule {

    private Long applicationModuleId;
    private String webModuleName;
    private String virtualHost;
    private Application application;
    
    protected ApplicationModule(){};
    
    public ApplicationModule(String webModuleName, String virtulHost, Application application){
    	this.webModuleName = webModuleName;
    	this.virtualHost = virtulHost;
    	this.application = application;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getApplicationModuleId() {
        return applicationModuleId;
    }

    @ManyToOne
    @JoinColumn(name = "application_id")
    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setApplicationModuleId(Long applicationModuleId) {
        this.applicationModuleId = applicationModuleId;
    }

    public String getWebModuleName() {
        return webModuleName;
    }

    public void setWebModuleName(String webModuleName) {
        this.webModuleName = webModuleName;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

  public String toString(){
	  return "ModuleId : " + applicationModuleId + " Module Name : " + webModuleName + " virtualHost : " + virtualHost;
  }


}
