package com.bhdx.wy.domain.dto;

import java.util.Date;

public class DefectDTO {
	private Integer defectId;
	private Integer defectCode;
	private String defectName;
	private String createBy;
	private String assignedUser;
	private Integer projectId;
	private String defectStatus;
	private String defecttype;
	private String defectSeverity;
	private String defectPriority;
	private String defectProbability;
	private String processingStatus;
	private String defectSolution;
	private String defectRemarks;
	private String defectImg;
	private Date createTime;
	public Integer getDefectId() {
		return defectId;
	}
	public void setDefectId(Integer defectId) {
		this.defectId = defectId;
	}
	public Integer getDefectCode() {
		return defectCode;
	}
	public void setDefectCode(Integer defectCode) {
		this.defectCode = defectCode;
	}
	public String getDefectName() {
		return defectName;
	}
	public void setDefectName(String defectName) {
		this.defectName = defectName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getAssignedUser() {
		return assignedUser;
	}
	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getDefectStatus() {
		return defectStatus;
	}
	public void setDefectStatus(String defectStatus) {
		this.defectStatus = defectStatus;
	}
	public String getDefecttype() {
		return defecttype;
	}
	public void setDefecttype(String defecttype) {
		this.defecttype = defecttype;
	}
	public String getDefectSeverity() {
		return defectSeverity;
	}
	public void setDefectSeverity(String defectSeverity) {
		this.defectSeverity = defectSeverity;
	}
	public String getDefectPriority() {
		return defectPriority;
	}
	public void setDefectPriority(String defectPriority) {
		this.defectPriority = defectPriority;
	}
	public String getDefectProbability() {
		return defectProbability;
	}
	public void setDefectProbability(String defectProbability) {
		this.defectProbability = defectProbability;
	}
	public String getProcessingStatus() {
		return processingStatus;
	}
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}
	public String getDefectSolution() {
		return defectSolution;
	}
	public void setDefectSolution(String defectSolution) {
		this.defectSolution = defectSolution;
	}
	public String getDefectRemarks() {
		return defectRemarks;
	}
	public void setDefectRemarks(String defectRemarks) {
		this.defectRemarks = defectRemarks;
	}
	public String getDefectImg() {
		return defectImg;
	}
	public void setDefectImg(String defectImg) {
		this.defectImg = defectImg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
