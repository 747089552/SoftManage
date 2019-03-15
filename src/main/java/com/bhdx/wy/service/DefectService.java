package com.bhdx.wy.service;

import com.bhdx.wy.domain.json.BaseJSON;
import com.bhdx.wy.domain.json.PageJSON;

public interface DefectService {

	/**
	 * 功能说明  :添加新bug
	 * 创建者      : wy
	 * 修改日期   : 2019年3月13日上午9:22:07
	 * @param defectCode
	 * @param defectName
	 * @param createBy
	 * @param assignedUser
	 * @param projectId
	 * @param defectType
	 * @param defectSeverity
	 * @param defectPriority
	 * @param defectProbability
	 * @param defectSolution
	 * @param defectRemarks
	 * @param defectImg
	 * @return 
	 * @return
	 */
	public String addDefect(Integer defectCode, String defectName, Integer createBy, Integer assignedUser,
			Integer projectId, Integer defectType, Integer defectSeverity, Integer defectPriority,
			Integer defectProbability, Integer defectSolution, String defectRemarks, String defectImg);

	/**
	 * 	查询bug列表
	 * @param defectCode
	 * @param defectName
	 * @param defectStatus
	 * @param defectSeverity
	 * @param defectPriority
	 * @param processingStatus
	 * @param defectSolution
	 * @param pageSize 
	 * @param pageNum 
	 * @return
	 */
	public PageJSON selectDefectList(String defectKeyOne, Integer defectStatus, Integer defectSeverity,
			Integer defectPriority, Integer processingStatus, Integer defectSolution, int pageNum, int pageSize);
	
	/**
	    *   查询defect详情
	 * @param defectCode
	 * @return
	 */
	public BaseJSON selectDefectDetail(Integer defectCode);

}
