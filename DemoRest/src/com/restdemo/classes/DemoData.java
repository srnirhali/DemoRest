package com.restdemo.classes;

import java.util.Date;

public class DemoData {

	private Date DateTime;
	private int ActiveJob;
	private int IdelJob;
	private float Utilization;
	
	
	public DemoData(Date d, int activeJob, int idelJob, float utilization) {
		super();
		DateTime = d;
		ActiveJob = activeJob;
		IdelJob = idelJob;
		Utilization = utilization;
	}
	public Date getD() {
		return DateTime;
	}
	public void setD(Date d) {
		this.DateTime = d;
	}
	public int getActiveJob() {
		return ActiveJob;
	}
	public void setActiveJob(int activeJob) {
		ActiveJob = activeJob;
	}
	public int getIdelJob() {
		return IdelJob;
	}
	public void setIdelJob(int idelJob) {
		IdelJob = idelJob;
	}
	public float getUtilization() {
		return Utilization;
	}
	public void setUtilization(float utilization) {
		Utilization = utilization;
	}
}
