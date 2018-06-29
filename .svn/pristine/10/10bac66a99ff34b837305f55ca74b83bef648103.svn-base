package com.nanshan.willow.auth.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanshan.willow.auth.entity.SysConfig;
import com.nanshan.willow.auth.mapper.AuthMapper;
import com.nanshan.willow.auth.service.AuthService;





@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthMapper authMapper;

	@Override
	public List<SysConfig> selectSysConfig() {
		return authMapper.selectSysConfig();
	}
	

	@Override
	public List<String> selectWhitelist() {
		return authMapper.selectWhitelist();
	}


	@Override
	public List<String> selectUserRoleUrl(String roleCode) {
		return authMapper.selectUserRoleUrl(roleCode);
	}


}
