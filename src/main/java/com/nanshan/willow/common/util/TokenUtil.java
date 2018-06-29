package com.nanshan.willow.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.nanshan.willow.auth.dto.UserInfo;
import com.nanshan.willow.common.consts.Consts;
import com.nanshan.willow.common.consts.SysConsts;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @ClassName:  TokenUtil   
 * @Description:token公共类 
 * @author: guoqh001
 * @date:   2017年7月7日 上午10:18:48   
 *
 */
public class TokenUtil {
	private TokenUtil(){
		
	}

	public static final String USER_INFO = "userInfo";
	public static final String USER_RELEVANCE = "userRelevanceId";
	public static final String SYS_USER = "sysUser";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String WXOPENID = "wxOpenId";
	public static final String CLIENT_TYPE = "clientType";
	public static final String ROLE_CODE = "roleCode";

	/**
	 * 创建token
	 * 
	 * @Title: createToken
	 * @author linbj001
	 * @Date 2017年3月17日 下午5:31:44
	 */
	public static String createToken(UserInfo userInfo) {
		Map<String, Object> clms = new HashMap<String, Object>();
		clms.put(USER_INFO, userInfo.toString());
		clms.put(USER_RELEVANCE, userInfo.getUserRelevanceId());

		return Jwts.builder().setClaims(clms)
				// 需要设置超时时间
				// .setExpiration(DateUtils.addSeconds(new Date(), 1))
				//
				.signWith(SignatureAlgorithm.HS256, CacheManagerUtil.getSysConfig(SysConsts.SYS_TOKEN_SECRET))
				//
				.compact();
	}

	
	public static String getToken(HttpServletRequest request) {
		return request.getHeader("token");
	}

	/**
	 * 校验token
	 * 
	 * @Title: verifyToken
	 * @author linbj001
	 * @Date 2017年3月17日 下午5:31:52
	 */
	public static void verifyToken(String token){
		Jwts.parser().setSigningKey(CacheManagerUtil.getSysConfig(SysConsts.SYS_TOKEN_SECRET)).parseClaimsJws(token);
	}

	/**
	 * 获取uuid
	 * @Title:        getUserUuid 
	 * @author        guoqh001
	 * @Date          2017年6月26日 上午10:40:54
	 */
	public static String getUserUuid(String token) {
		Claims clms = Jwts.parser().setSigningKey(CacheManagerUtil.getSysConfig(SysConsts.SYS_TOKEN_SECRET)).parseClaimsJws(token).getBody();
		return clms.get(USER_RELEVANCE, String.class);
	}
	/**
	 * 
	* @Title: getUserAccount 
	* @Description: 获取用户账号
	* @param @param token
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getUserAccount(String token) {
		Claims clms = Jwts.parser().setSigningKey(CacheManagerUtil.getSysConfig(SysConsts.SYS_TOKEN_SECRET)).parseClaimsJws(token).getBody();
		return clms.get(USER_ACCOUNT, String.class);
	}
	
	/**
	 * 获取用户信息
	 * @Title:        getUserInfo 
	 * @author        guoqh001
	 * @Date          2017年7月7日 上午10:41:39
	 */
	public static UserInfo getUserInfo(String token) {
		Claims clms = Jwts.parser().setSigningKey(CacheManagerUtil.getSysConfig(SysConsts.SYS_TOKEN_SECRET)).parseClaimsJws(token).getBody();
		String json = clms.get(USER_INFO, String.class);
		return JSON.parseObject(json, UserInfo.class);
	}
	
	
	/**
	 * 校验uuid与token解析出来uuid是否一致
	 * @Title:        checkUserUuid 
	 * @author        guoqh001
	 * @Date          2017年6月26日 下午2:56:42
	 */
	public static boolean checkUserUuid(HttpServletRequest request,String userRelevanceId){
		//认证开关关闭则不比较
		String authCfg = CacheManagerUtil.getSysConfig(SysConsts.SYS_CONF_AUTHCFG); 
		if(Consts.AUTH_TOKEN_CFG.equals(authCfg)){
			return true;
		}
		String uuid = (String) request.getAttribute("uuid");
		if(!uuid.equals(userRelevanceId)){
			return false;
		}
		return true;
	}
	
}
