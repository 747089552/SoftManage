package com.bhdx.wy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhdx.wy.domain.json.BaseJSON;
import com.bhdx.wy.domain.json.PageJSON;
import com.bhdx.wy.service.DefectService;
import com.bhdx.wy.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/defect")
@Api(value = "缺陷服务api")
public class defectController {
	

	@Autowired
	private DefectService defectService;
	
	/**
	 * 创建新bug
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
	 */
	@CrossOrigin
	@ApiOperation("添加bug")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "defectCode", dataType = "Integer", required = true, value = "缺陷编码", defaultValue = "0001"),                           
		@ApiImplicitParam(paramType = "query", name = "defectName", dataType = "String", required = true, value = "缺陷名称", defaultValue = "bug测试"),
		@ApiImplicitParam(paramType = "query", name = "createBy", dataType = "Integer", required = true, value = "缺陷创建人", defaultValue = "7728"),
		@ApiImplicitParam(paramType = "query", name = "assignedUser", dataType = "Integer", required = true, value = "缺陷被指派人", defaultValue = "7736"),
		@ApiImplicitParam(paramType = "query", name = "projectId", dataType = "Integer", required = true, value = "所属项目id", defaultValue = "1000"),
		@ApiImplicitParam(paramType = "query", name = "defectType", dataType = "Integer", required = true, value = "缺陷类型", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "defectSeverity", dataType = "Integer", required = true, value = "缺陷严重程度", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "defectPriority", dataType = "Integer", required = true, value = "优先级", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "defectProbability", dataType = "Integer", required = true, value = "发生概率", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "defectSolution", dataType = "Integer", required = true, value = "解决方案", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "defectRemarks", dataType = "String", required = true, value = "缺陷说明", defaultValue = "测试错误，请及时修改"),
		@ApiImplicitParam(paramType = "query", name = "defectImg", dataType = "String", required = true, value = "图片说明", defaultValue = "此处为图片说明链接"),
	})
	@RequestMapping(value = "/addDefect", method = RequestMethod.GET)
	public String addDefect(Integer defectCode,String defectName,
							Integer createBy,Integer assignedUser,
							Integer projectId,Integer defectType,
							Integer defectSeverity,Integer defectPriority,
							Integer defectProbability,Integer defectSolution,
							String defectRemarks,String defectImg){
		return defectService.addDefect(defectCode,defectName,createBy,assignedUser,projectId,defectType,defectSeverity,defectPriority,defectProbability,defectSolution,defectRemarks,defectImg);
	}
	
	

	@CrossOrigin
	@ApiOperation("查询bug列表")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "defectKey", dataType = "Integer", required = false, value = "缺陷编码和名称模糊", defaultValue = ""),
		@ApiImplicitParam(paramType = "query", name = "defectStatus", dataType = "Integer", required = false, value = "缺陷状态", defaultValue = ""), 
		@ApiImplicitParam(paramType = "query", name = "defectSeverity", dataType = "Integer", required = false, value = "严重程度", defaultValue = ""), 
		@ApiImplicitParam(paramType = "query", name = "defectPriority", dataType = "Integer", required = false, value = "优先级", defaultValue = ""),  
		@ApiImplicitParam(paramType = "query", name = "processingStatus", dataType = "Integer", required = false, value = "处理状态", defaultValue = ""), 
		@ApiImplicitParam(paramType = "query", name = "defectSolution", dataType = "Integer", required = false, value = "解决方案", defaultValue = ""),    
		@ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "起始位置", defaultValue = "1"),
		@ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "每页显示数据量", defaultValue = "10"),
	})
	@RequestMapping(value = "/selectDefectList", method = RequestMethod.GET)
	public PageJSON selectDefectList(String defectKey ,Integer defectStatus,
								 Integer defectSeverity,Integer defectPriority,Integer processingStatus,Integer defectSolution,int pageNum,int pageSize){
		
		return defectService.selectDefectList(defectKey, defectStatus,
				  						defectSeverity, defectPriority, processingStatus, defectSolution,pageNum,pageSize);
	}
	
	@CrossOrigin
	@ApiOperation("查询bug详情")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "defectCode", dataType = "Integer", required = false, value = "缺陷编码", defaultValue = ""),
	})
	@RequestMapping(value = "/selectDefectDetail", method = RequestMethod.GET)
	public BaseJSON selectDefectDetail(Integer defectCode){
		
		return defectService.selectDefectDetail(defectCode);
	}

}





