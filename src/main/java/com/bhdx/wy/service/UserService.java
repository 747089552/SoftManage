package com.bhdx.wy.service;

import com.bhdx.wy.domain.json.BaseJSON;

public interface UserService {
	/**
	 * 功能说明  :用户登录
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日上午10:04:51
	 * @param account
	 * @param password
	 * @return 
	 * @return
	 */
	public BaseJSON login(String account, String password);
	
	/**
	 * 功能说明  :用户注册
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日上午10:05:09
	 * @param account
	 * @param password
	 * @param username
	 * @param phone
	 * @param card
	 * @param userGrade
	 * @return 
	 * @return
	 */
	public String register(String account, String password, String username, String phone, String card,
			Integer userGrade,Integer companyId);
	/**
	 * 功能说明  :用户名校验
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日上午11:20:54
	 * @param account
	 * @return 
	 * @return
	 */
	public String checkAccount(String account);

	public String checkPhone(String phone);
	

}
