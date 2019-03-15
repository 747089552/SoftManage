/*
* Copyright (c) 2005 Infoservice, Inc. All  Rights Reserved.
* This software is published under the terms of the Infoservice Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* CreateDate : 2018-09-19 16:16:48
* CreateBy   : ccyy-yh
* Comment    : generate by com.sgm.po.POGen
*/

package com.bhdx.wy.domain.po;

import java.util.Date;

public class UserTokenPO{

	private String token;
	private Date createTime;
	private String refToken;
	private Integer userId;
	private Date expireTime;
	private Integer tokenId;
	private Integer isValid;

	public void setToken(String token){
		this.token=token;
	}

	public String getToken(){
		return this.token;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	public void setRefToken(String refToken){
		this.refToken=refToken;
	}

	public String getRefToken(){
		return this.refToken;
	}

	public void setUserId(Integer userId){
		this.userId=userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setExpireTime(Date expireTime){
		this.expireTime=expireTime;
	}

	public Date getExpireTime(){
		return this.expireTime;
	}

	public void setTokenId(Integer tokenId){
		this.tokenId=tokenId;
	}

	public Integer getTokenId(){
		return this.tokenId;
	}

	public void setIsValid(Integer isValid){
		this.isValid=isValid;
	}

	public Integer getIsValid(){
		return this.isValid;
	}

}