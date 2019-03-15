package com.bhdx.wy.domain.dto;

import java.util.Date;

public class ProjectDTO {
	private Integer projectCode;
	private String projectName;
	private Integer projectStatus;
	private String username;
	private String projectGroupName;
	private Date creatTime;
	public Integer getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProjectGroupName() {
		return projectGroupName;
	}
	public void setProjectGroupName(String projectGroupName) {
		this.projectGroupName = projectGroupName;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
	
}
