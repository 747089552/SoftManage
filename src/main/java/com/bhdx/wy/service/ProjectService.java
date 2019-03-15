package com.bhdx.wy.service;

import java.util.Date;
import java.util.List;

import com.bhdx.wy.domain.dto.ProjectDTO;
import com.bhdx.wy.domain.po.ProjectGroupPO;
import com.bhdx.wy.domain.po.ProjectPO;

public interface ProjectService {
	/**
	 * 功能说明  :添加项目分组
	 * 创建者      : wy
	 * 修改日期   : 2019年1月17日上午8:56:08
	 * @param projectGroupCode
	 * @param projectGroupName
	 * @param projectGroupRemarks
	 * @return 
	 * @return
	 */
	public String addProjectGroup(Integer projectGroupCode, String projectGroupName, String projectGroupRemarks);

	public List<ProjectGroupPO> getProjectGroup();

	public String addProject(Integer projectCode, String projectName, Integer userId, String projectRemarks,
			Integer projectStatus, Integer projectGroupId);

	public List<ProjectDTO> getProject(String projectName, String createTime);

	public String updateProject(Integer projectCode, String projectName, String remarks, String projectStatus);

	public String deleteProject(Integer projectCode);
	

}
