package com.i2e.baselineapp.model;
import javax.persistence.*;

/**
 * Created by anirudh on 11/23/15.
 */
@Entity
@Table(name = "baseline_table")
public class Baseline {

	protected Baseline(){};
	/**
	 * This is needed to initialize and test
	 * @param baselineName
	 * @param odcStatus
	 * @param ssbStatus
	 * @param application
	 */
	public Baseline( String baselineName, String odcStatus, String ssbStatus, Application application){
		this.baselineName = baselineName;
		this.odcStatus = odcStatus;
		this.ssbStatus = ssbStatus;
		this.application = application;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBaselineID() {
        return baselineID;
    }

    public void setBaselineID(Long baselineID) {
        this.baselineID = baselineID;
    }

    public String getBaselineName() {
        return baselineName;
    }

    public void setBaselineName(String baselineName) {
        this.baselineName = baselineName;
    }

    public String getOdcStatus() {
        return odcStatus;
    }

    public void setOdcStatus(String odcStatus) {
        this.odcStatus = odcStatus;
    }

    public String getSsbStatus() {
        return ssbStatus;
    }

    public void setSsbStatus(String ssbStatus) {
        this.ssbStatus = ssbStatus;
    }

    @ManyToOne
    @JoinColumn(name = "application_id")
    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    private Long baselineID;
    private String baselineName;
    private String odcStatus;
    private String ssbStatus;
    private Application application;



}
