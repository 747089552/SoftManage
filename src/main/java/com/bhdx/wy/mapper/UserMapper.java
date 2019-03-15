package com.bhdx.wy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bhdx.wy.domain.po.UserPO;

@Mapper
public interface UserMapper {
	
	/**
	 * 功能说明 :通过账号获取用户信息
	 * 创建者      : wy
	 * 修改日期   : 2018年12月19日上午11:05:26
	 * @param account
	 * @return 
	 * @return
	 */
	public UserPO getUserByAccount(@Param("account") String account);
	
	/**
	 * 功能说明  :用户注册
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日上午10:13:44
	 * @param account
	 * @param password
	 * @param username
	 * @param phone
	 * @param card
	 * @param userGrade
	 * @return 
	 * @return
	 */
	public int addUser(@Param("account")String account,
			@Param("password")String password, 
			@Param("username")String username, 
			@Param("phone")String phone, 
			@Param("card")String card, 
			@Param("userGrade")Integer userGrade,
			@Param("companyId")Integer companyId);
	/**
	 * 功能说明  :账号校验
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日下午3:40:02
	 * @param account
	 * @return 
	 * @return
	 */
	public List<String> getUserAccount(@Param("account")String account);

	/**
	 * 功能说明  :手机号校验
	 * 创建者      : wy
	 * 修改日期   : 2018年12月24日下午3:40:27
	 * @param phone
	 * @return 
	 * @return
	 */
	public List<String> getUserPhone(@Param("phone")String phone);


}
