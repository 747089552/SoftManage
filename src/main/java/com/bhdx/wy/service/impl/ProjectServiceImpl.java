package com.bhdx.wy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhdx.wy.domain.dto.ProjectDTO;
import com.bhdx.wy.domain.po.ProjectGroupPO;
import com.bhdx.wy.domain.po.ProjectPO;
import com.bhdx.wy.mapper.ProjectMapper;
import com.bhdx.wy.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectMapper projectMapper;
	
	/*
	 * 添加项目分组
	 */
	@Override
	public String addProjectGroup(Integer projectGroupCode, String projectGroupName, String projectGroupRemarks) {
		 List<String> groupList = projectMapper.getProjectGroupCode(projectGroupCode);
		 if(groupList.size()>0) {
				return "项目代码重复！";
		 }else {
				int projectGroupNum = projectMapper.addProjectGroup(projectGroupCode,projectGroupName,projectGroupRemarks);
				return "添加成功!";
		 }
	}

	@Override
	public List<ProjectGroupPO> getProjectGroup() {
		List<ProjectGroupPO> list =projectMapper.getProjectGroup();
		return projectMapper.getProjectGroup();
	}

	@Override
	public String addProject(Integer projectCode, String projectName, Integer userId, String projectRemarks,
			Integer projectStatus, Integer projectGroupId) {
		 List<String> projectList = projectMapper.getProjectCode(projectCode);
		 if(projectList.size()>0){
			 return "项目代码重复，请重新添加！";
		 }else{
			 Date createTime = new Date();
			 int projectNum = projectMapper.addProject(projectCode, projectName, userId,projectRemarks,projectStatus,projectGroupId,createTime);
			 if(projectMapper.addProject(projectCode, projectName, userId,projectRemarks,projectStatus,projectGroupId,createTime)>0) {
				 return "项目添加成功！";
			 }else {
				 return "添加失败";
			 }
		 }
	}

	@Override
	public List<ProjectDTO> getProject(String projectName, String createTime) {
		return projectMapper.getProject(projectName,createTime);
  	}
	/**
	 * 修改项目信息
	 */
	@Override
	public String updateProject(Integer projectCode, String projectName, String remarks, String projectStatus){
		Date updateTime = new Date();
		int projectNum = projectMapper.updateProject(projectCode,projectName,remarks,projectStatus,updateTime);
		if(projectNum==1) {
			return "修改成功";
		}else {
			return "修改失败";
		}
	}
	/**
	 * 删除项目
	 */
	@Override
	public String deleteProject(Integer projectCode) {
		int projectNum = projectMapper.deleteProject(projectCode);
		if(projectNum>0) {
			return "删除成功";
		}else {
			return "删除失败";
		}
	}
}
