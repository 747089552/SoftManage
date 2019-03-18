package com.bhdx.wy.service.impl;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhdx.wy.domain.dto.DefectDTO;
import com.bhdx.wy.domain.json.BaseJSON;
import com.bhdx.wy.domain.json.PageJSON;
import com.bhdx.wy.mapper.DefectMapper;
import com.bhdx.wy.service.DefectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
	/**
	 * 获取缺陷列表
	 */
	@Override
	public PageJSON selectDefectList(String defectKeyOne, Integer defectStatus, Integer defectSeverity,
			Integer defectPriority, Integer processingStatus, Integer defectSolution, int pageNum, int pageSize) {
		PageJSON pageJSON = new PageJSON();
		String defectKey = "";
		try {
			defectKeyOne = defectKeyOne.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
			defectKey = URLDecoder.decode(defectKeyOne, "UTF-8"); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Page<Object> pages = PageHelper.startPage(pageNum, pageSize);
		List<DefectDTO> list = defectMapper.selectDefectList(defectKey,defectStatus,defectSeverity,
															 defectPriority,processingStatus,defectSolution);
		pageJSON.setTotal(pages.getTotal());
		pageJSON.setPages(pages.getPages());
		pageJSON.setPageNum(pages.getPageNum());
		pageJSON.setPageSize(pages.getPageSize());
		pageJSON.setResult(list);
		return pageJSON;
	}
	
	/**
	 * 获取缺陷详情
	 */
	@Override
	public BaseJSON selectDefectDetail(Integer defectCode) {
		BaseJSON baseJSON = new BaseJSON();
		DefectDTO defectDTO = defectMapper.getdefectDetails(defectCode);
		baseJSON.setResult(defectDTO);
		return baseJSON;
	}
	
	/**
	 * 修改缺陷信息
	 */
	@Override
	public String updateDefectDetail(Integer defectCode, String defectName, Integer defectStatus,
			Integer defectSeverity, Integer defectPriority, Integer processingStatus, Integer defectSolution,
			String defectRemarks, String defectImg, Integer updateBy) {
		Date updateTime = new Date();
		int updateDefectNum = defectMapper.updateDefectDetail(defectCode,defectName,defectStatus,defectSeverity,
															  defectPriority,processingStatus,defectSolution,defectRemarks,defectImg,updateBy,updateTime);
		if(updateDefectNum>1) {
	
			return "修改成功";
		}else {
			return "修改失败";
		}
	}
	
}












