package com.nanshan.willow.auth.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nanshan.willow.auth.entity.SysConfig;
@Repository
public interface AuthMapper {
	
	//查询认证开关是否开启
	List<SysConfig> selectSysConfig();
	
	//读取白名单
	List<String> selectWhitelist();
	
	//查询用户角色url
	List<String> selectUserRoleUrl(String roleCode);
	
	//查询后台管理用户角色url
	List<String> selectSysUserRoleUrl(String SysRoleCode);
}
