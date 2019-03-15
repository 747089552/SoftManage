package com.bhdx.wy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bhdx.wy.domain.dto.ProjectDTO;
import com.bhdx.wy.domain.po.ProjectGroupPO;
@Mapper
public interface ProjectMapper {
	
	//添加项目列表
	public int addProjectGroup(
			@Param("projectGroupCode")Integer projectGroupCode, 
			@Param("projectGroupName")String projectGroupName, 
			@Param("projectGroupRemarks")String projectGroupRemarks); 

	public List<String> getProjectGroupCode(@Param("projectGroupCode")Integer projectGroupCode);

	public List<ProjectGroupPO> getProjectGroup();

	public List<String> getProjectCode(@Param("projectCode")Integer projectCode);

	public int addProject(
			@Param("projectCode")Integer projectCode, 
			@Param("projectName")String projectName, 
			@Param("userId")Integer userId, 
			@Param("projectRemarks")String projectRemarks,
			@Param("projectStatus")Integer projectStatus, 
			@Param("projectGroupId")Integer projectGroupId,
			@Param("createTime")Date createTime);

	public List<ProjectDTO> getProject(@Param("projectName")String projectName, @Param("createTime")String createTime);

	public int updateProject(
			@Param("projectCode")Integer projectCode, 
			@Param("projectName")String projectName, 
			@Param("remarks")String remarks, 
			@Param("projectStatus")String projectStatus,
			@Param("updateTime") Date updateTime);

	public int deleteProject(@Param("projectCode")Integer projectCode);

}
