package com.nanshan.willow.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanshan.willow.auth.entity.User;
import com.nanshan.willow.auth.mapper.UserAuthMapper;
import com.nanshan.willow.auth.service.UserAuthService;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	private Logger log = LoggerFactory.getLogger(UserAuthServiceImpl.class);
	
	@Autowired
	UserAuthMapper userAuthMapper;
	
	@Override
	public User getPasswordInfo(String userAccount) {
		User user = null;
		try{
			user = userAuthMapper.getPasswordInfo(userAccount);
		}catch(Exception e){
			log.error("获取用户信息异常",e);
			return user;
		}
		return user;
	}

	@Override
	public void updatePasswordNum(User user) {
		userAuthMapper.updatePasswordNum(user);
	}

	@Override
	public void updatePasswordSize(String userRelevanceId) {
		userAuthMapper.updatePasswordSize(userRelevanceId);
	}
}
