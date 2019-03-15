package com.bhdx.wy.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bhdx.wy.domain.dto.DefectDTO;
import com.bhdx.wy.domain.po.DefectPO;


@Mapper
public interface DefectMapper {

	public int addDefect(@Param("defectCode")Integer defectCode, //bug编码
					 @Param("defectName")String defectName,//bug名称
					 @Param("createBy")Integer createBy,//bug创建人
					 @Param("assignedUser")Integer assignedUser,//被指派人
					 @Param("projectId")Integer projectId,//所属项目id
					 @Param("defectType")Integer defectType,//bug类型
					 @Param("defectSeverity")Integer defectSeverity,//严重程度
					 @Param("defectPriority")Integer defectPriority,//优先级
					 @Param("defectProbability")Integer defectProbability,//发生概率
					 @Param("defectSolution")Integer defectSolution,//解决方式
					 @Param("defectRemarks")String defectRemarks,//bug说明
					 @Param("defectImg")String defectImg,//bug图片介绍路径
					 @Param("defectStatus")Integer defectStatus,//缺陷状态
					 @Param("processingStatus")Integer processingStatus,
					 @Param("createTime")Date createTime);//bug处理状态
	/**
	 * 功能说明  :获取bug代码
	 * 创建者      : wy
	 * 修改日期   : 2019年3月13日下午3:31:53
	 * @param defectCode
	 * @return 
	 * @return
	 */
	public List<DefectPO> selectDefectCode(@Param("defectCode")int defectCode);
	
	/**
	 * 查询缺陷列表
	 * @param defectCode
	 * @param defectName
	 * @param defectStatus
	 * @param defectSeverity
	 * @param defectPriority
	 * @param processingStatus
	 * @param defectSolution
	 * @return
	 */
	public List<DefectDTO> selectDefectList(
			@Param("defectKey")String defectKey,
			@Param("defectStatus")Integer defectStatus,
			@Param("defectSeverity")Integer defectSeverity,
			@Param("defectPriority")Integer defectPriority,
			@Param("processingStatus")Integer processingStatus,
			@Param("defectSolution")Integer defectSolution);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
