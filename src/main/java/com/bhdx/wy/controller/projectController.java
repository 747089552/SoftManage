package com.bhdx.wy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhdx.wy.domain.dto.ProjectDTO;
import com.bhdx.wy.domain.json.BaseJSON;
import com.bhdx.wy.domain.po.ProjectGroupPO;
import com.bhdx.wy.domain.po.ProjectPO;
import com.bhdx.wy.service.ProjectService;
import com.bhdx.wy.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/project")
@Api(value = "项目服务api")
public class projectController {
	@Autowired
	private ProjectService projectService;
	@CrossOrigin
	@ApiOperation("添加项目分组")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "projectGroupCode", dataType = "Integer", required = true, value = "项目分组编码", defaultValue = "admin"),
		@ApiImplicitParam(paramType = "query", name = "projectGroupName", dataType = "String", required = true, value = "项目分组名称", defaultValue = "潘大宇"),
		@ApiImplicitParam(paramType = "query", name = "projectGroupRemarks", dataType = "String", required = true, value = "项目分组简介", defaultValue = "13244231517"),
	})
	@RequestMapping(value = "/addProjectGroup", method = RequestMethod.GET)
	public String addProjectGroup(Integer projectGroupCode,String projectGroupName,String projectGroupRemarks) {
		return projectService.addProjectGroup(projectGroupCode,projectGroupName,projectGroupRemarks);
	}
	/**
	 *查询项分组的信息
	 */
	@CrossOrigin
	@ApiOperation("查询项目分组")
	@RequestMapping(value = "/getProjectGroup", method = RequestMethod.GET)
	public List<ProjectGroupPO> getProjectGroup(){
		return projectService.getProjectGroup();
	}
	
	/**
	 * 添加项目
	 */

	@CrossOrigin
	@ApiOperation("添加项目")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "projectCode", dataType = "Integer", required = true, value = "项目编码", defaultValue = "123456"),
		@ApiImplicitParam(paramType = "query", name = "projectName", dataType = "String", required = true, value = "项目名称", defaultValue = "潘大宇"),
		@ApiImplicitParam(paramType = "query", name = "userId", dataType = "Integer", required = true, value = "创建人id", defaultValue = "002"),
		@ApiImplicitParam(paramType = "query", name = "projectRemarks", dataType = "String", required = true, value = "项目备注", defaultValue = "13244231517"),
		@ApiImplicitParam(paramType = "query", name = "projectStatus", dataType = "Integer", required = true, value = "项目状态", defaultValue = "0001"),
		@ApiImplicitParam(paramType = "query", name = "projectGroupId", dataType = "Integer", required = true, value = "项目分组id", defaultValue = "123213"),
	})
	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String addProject(Integer projectCode,String projectName,Integer userId,String projectRemarks,Integer projectStatus, Integer projectGroupId){
		
		return projectService.addProject(projectCode,projectName,userId,projectRemarks,projectStatus,projectGroupId);
	}
	
	/**
	 * 查询项目
	 */
	@CrossOrigin
	@ApiOperation("查询项目")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "projectName", dataType = "String", required = false, value = "项目名称", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "createTime", dataType = "Date", required = false, value = "创建时间", defaultValue = ""),
	})
	@RequestMapping(value = "/getProject", method = RequestMethod.GET)
	public List<ProjectDTO> getProject(String projectName,String createTime){
		return projectService.getProject(projectName,createTime);
	}
	
	/**
	 * 修改项目信息:通过项目代码可以修改项目的名称(name)，介绍(remarks)，状态(status)
	 */
	@CrossOrigin
	@ApiOperation("修改项目")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "projectCode", dataType = "Integer", required = true, value = "项目代码", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "projectName", dataType = "String", required = false, value = "项目名称", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "remarks", dataType = "String", required = false, value = "项目备注", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "projectStatus", dataType = "Integer", required = false, value = "项目状态", defaultValue = ""),
	})
	@RequestMapping(value = "/updateProject", method = RequestMethod.POST)
	public String updateProject(Integer projectCode,String projectName,String remarks,String projectStatus) {
	
		return projectService.updateProject(projectCode,projectName,remarks,projectStatus);
	}
	
	/**
	 * 删除项目信息
	 */

	@CrossOrigin
	@ApiOperation("删除项目")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "projectCode", dataType = "Integer", required = true, value = "项目代码", defaultValue = ""),
	})
	@RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
	public String deleteProject(Integer projectCode) {
		return projectService.deleteProject(projectCode);
	}
	
}	
