package com.bhdx.wy.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhdx.wy.mapper.DefectMapper;
import com.bhdx.wy.service.DefectService;

@Service
public class DefectServiceImpl implements DefectService{
	
	@Autowired
	private DefectMapper defectMapper;
	
	/**
	 * 创建bug
	 */
	@Override
	public String addDefect(Integer defectCode, String defectName, Integer createBy, Integer assignedUser,
			Integer projectId, Integer defectType, Integer defectSeverity, Integer defectPriority,
			Integer defectProbability, Integer defectSolution, String defectRemarks, String defectImg) {
		Integer defectStatus = 10010001;//缺陷状态为激活状态
		Integer  processingStatus = 10060001; //处理状态为确认中
		Date createTime = new Date();
		int defectCodeNum = defectMapper.selectDefectCode(defectCode).size();
		if(defectCodeNum>0){
			return "bug代码重复，请重新编辑";
		}else {
			int defectNum = defectMapper.addDefect(defectCode,defectName,createBy,
					  assignedUser,projectId,defectType,
					  defectSeverity,defectPriority,defectProbability,
					  defectSolution,defectRemarks,defectImg,
					  defectStatus,processingStatus,createTime);
			if(defectNum>=1) {
				return "bug创建成功";
			}else {
				return "bug创建失败";
			}
		}
	}

	
	
	
}
