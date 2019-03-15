package com.bhdx.wy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhdx.wy.domain.json.BaseJSON;
import com.bhdx.wy.domain.po.UserPO;
import com.bhdx.wy.mapper.UserMapper;
import com.bhdx.wy.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public BaseJSON login(String account, String password) {
		BaseJSON json = new BaseJSON();
		UserPO userInfo = userMapper.getUserByAccount(account);	
		try {
			//检查账号密码是否存在
			if(userInfo != null) {
				//验证用户名密码是否正确
				if(password.equals(userInfo.getPassword())){
					json.setResult(userInfo);
				}else {
					json.setCode(2);
					json.setMessage("用户名或者密码错误！");
				}
			}else {
				//用户未注册
				json.setCode(1);
				json.setMessage("用户不存在");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return json;
	}
	
	@Override
	public String register(String account, String password, String username, String phone, String card,
			Integer userGrade,Integer companyId) {
		String  regex="^\\d+$";
		List<String> accountList = userMapper.getUserAccount(account);
		List<String> phoneList = userMapper.getUserPhone(phone);
		
		if(accountList.size()>0) {
			return "账号已存在！";
		}else {
			if(phoneList.size()>0) {
				return "手机号已存在！";
			}else if(phone.length() != 11 ||phone.matches(regex)==false){
				return "请输入正确的手机号！";
			}else {
				int registerNum = userMapper.addUser(account,password,username,phone,card,userGrade,companyId);
				if(registerNum>0) {
					return "注册成功";
				}else {
					return "注册失败";
				}
				
			}
		}
	}
	@Override
	public String checkAccount(String account) {
		List<String> accountList = userMapper.getUserAccount(account);
		if(accountList.size()>0) {
			return "账号已存在！";
		}else {
			return "账号可用！";
		}
	}

	@Override
	public String checkPhone(String phone) {
		List<String> phoneList = userMapper.getUserPhone(phone);
		if(phoneList.size()>0) {
			return "手机号已存在！";
		}else {
			return "手机号可用！";
		}
	}
	
}
