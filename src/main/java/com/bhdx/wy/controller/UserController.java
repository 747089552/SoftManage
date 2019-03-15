package com.bhdx.wy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhdx.wy.domain.json.BaseJSON;
import com.bhdx.wy.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "用户服务api")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 功能说明  :用户登录
	 * 创建者      : wy
	 * 修改日期   : 2018年12月20日上午9:05:21
	 * @param account
	 * @param password
	 * @return 
	 * @return	
	 */

	@CrossOrigin
	@ApiOperation("用户登录")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "account", dataType = "String", required = true, value = "用户账号", defaultValue = "admin"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "密码", defaultValue = "1"),
		})
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public BaseJSON login(String account, String password) {
		return userService.login(account,password);
	}
	
	/**
	 * 功能说明  :用户注册
	 * 创建者      : wy
	 * 修改日期   : 2018年12月20日上午9:05:16 
	 * @return
	 */
	@CrossOrigin
	@ApiOperation("用户注册")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "account", dataType = "String", required = true, value = "用户账号", defaultValue = "admin"),
		@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "密码", defaultValue = "1"),
		@ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户名", defaultValue = "潘大宇"),
		@ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", required = true, value = "手机号", defaultValue = "13244231517"),
		@ApiImplicitParam(paramType = "query", name = "card", dataType = "String", required = true, value = "身份证号	", defaultValue = "220802199609153030"),
		@ApiImplicitParam(paramType = "query", name = "companyId", dataType = "Integer", required = true, value = "公司id", defaultValue = "10010001"),
		@ApiImplicitParam(paramType = "query", name = "userGrade", dataType = "Integer", required = true, value = "用户级别", defaultValue = "1"),
	})
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(String account,String password,String username,String phone,String card,Integer userGrade,Integer companyId) {
		return userService.register(account,password,username,phone,card,userGrade,companyId);
	}
	
	/**
	 * 功能说明  :校验账号是否存在
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日上午10:58:17
	 * @return 
	 * @return
	 */
	@CrossOrigin
	@ApiOperation("账号校验")
		@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "account", dataType = "String", required = true, value = "用户账号", defaultValue = "admin"),
		})
		@RequestMapping(value = "/checkAccount", method = RequestMethod.GET)
	public String checkAccount(String account) {
		
		return userService.checkAccount(account);
	}

	
	@CrossOrigin
	@ApiOperation("手机号码校验")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", required = true, value = "手机号码校验", defaultValue = "13123456789"),
	})
	@RequestMapping(value = "/checkPhone", method = RequestMethod.GET)
	public String checkPhone(String phone) {
		return userService.checkPhone(phone);	
	}
	
	
	
	
}
