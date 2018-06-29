package com.nanshan.willow.auth.service;

import java.util.List;

import com.nanshan.willow.auth.entity.SysConfig;

public interface AuthService {
	
	//查询认证开关是否开启
	List<SysConfig> selectSysConfig();
	
	//读取白名单
	List<String> selectWhitelist();
	
	//查询用户角色url
	List<String> selectUserRoleUrl(String roleCode);
	

}
