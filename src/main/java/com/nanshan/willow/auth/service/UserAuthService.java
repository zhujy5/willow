package com.nanshan.willow.auth.service;

import com.nanshan.willow.auth.entity.User;


public interface UserAuthService {
	
	//通过密码获取用户信息
	User getPasswordInfo(String userAccount);
	
	//重置密码次数
	void updatePasswordNum(User user);
	
	void updatePasswordSize(String userRelevanceId);
	
}
