package com.nanshan.willow.auth.util;

import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nanshan.willow.auth.dto.AuthResultDto;
import com.nanshan.willow.auth.dto.TokenValidateForm;
import com.nanshan.willow.auth.dto.UserInfo;
import com.nanshan.willow.common.consts.Consts;
import com.nanshan.willow.common.util.CacheManagerUtil;
import com.nanshan.willow.common.util.RedisDao;
import com.nanshan.willow.common.util.TokenUtil;
import com.nanshan.willow.common.util.Tools;


/**
 * 
 * @ClassName:  AuthUtil   
 * @Description:验证token
 * @author: zhujy001
 * @date:   2018年2月10日 下午3:33:33
 *
 */
public class ValidTokenManager {
	private   Logger log = LoggerFactory.getLogger(ValidTokenManager.class);
	
	
	@Autowired
	RedisDao redisDao;

	
	public AuthResultDto doValidate(TokenValidateForm form,ServletRequest request) {
		log.info("入参: " + form);
		AuthResultDto result = new AuthResultDto();

		String token = form.getToken();
		String accessResource = form.getAccessResource();

		if (StringUtils.isBlank(token) || StringUtils.isBlank(accessResource)) {
			result.setResultCode(ResultCode.WRO_ARGS.getCode());
			result.setResultMsg(ResultCode.WRO_ARGS.getMsg());
			log.info("出参: " + result);
			return result;
		}
		try {
			

			UserInfo userInfo = TokenUtil.getUserInfo(token);
			if(userInfo == null){
				result.setResultCode(ResultCode.NON_TOKEN.getCode());
	            result.setResultMsg(ResultCode.NON_TOKEN.getMsg());
	            return result;
			}
			
			//校验角色是否为空，为空则返回
			String roleCode = userInfo.getRoleCode();
			if(Tools.isEmpty(roleCode)){
				result.setResultCode(ResultCode.NO_ROLE.getCode());
	            result.setResultMsg(ResultCode.NO_ROLE.getMsg());
	            return result;
			}
			//校验角色是否有权限
			List<String> roleList = CacheManagerUtil.getRoleList(roleCode);
			if(roleList.isEmpty()){
				result.setResultCode(ResultCode.NO_PERMISSION.getCode());
	            result.setResultMsg(ResultCode.NO_PERMISSION.getMsg());
	            return result;
			}
			//判断该角色有没有权限访问该url
			if(!getUserUrlRole(accessResource,roleList)){
				result.setResultCode(ResultCode.NO_PERMISSION.getCode());
	            result.setResultMsg(ResultCode.NO_PERMISSION.getMsg());
	            return result;
			}
			//校验用户uuid和请求类型是否为空
			String uuid = userInfo.getUserRelevanceId();
			String clientType = userInfo.getClientType();
			if(Tools.isEmpty(uuid) || Tools.isEmpty(clientType)){
				result.setResultCode(ResultCode.WRO_ARGS.getCode());
	            result.setResultMsg(ResultCode.WRO_ARGS.getMsg());
	            return result;
			}
			request.setAttribute("uuid", uuid);
			//微信校验
			if(Consts.BBPARK_CLIENT_TYPE_WX.equals(clientType)){
				String wxOpenId = userInfo.getWxOpenId();
				AuthResultDto resultDro = doValidateWx(result,wxOpenId);
				if(resultDro != null){
					return resultDro;
				}
			}
			//校验redis token是否存在
			String redisToken = redisDao.get(Consts.REDIS_AUTH_KEY+clientType+":"+uuid);
	        if (redisToken == null) {
	            result.setResultCode(ResultCode.EXPIRED_TOKEN.getCode());
	            result.setResultMsg(ResultCode.EXPIRED_TOKEN.getMsg());
	            return result;
	        }
	        //校验token是否相同
	        log.info("入参token"+token+"  ----redis Token"+redisToken+"---clientType--"+clientType+"--uuid--"+uuid);
	        if(!redisToken.equals(token)){
	        	result.setResultCode(ResultCode.ERR_TOKEN.getCode());
	            result.setResultMsg(ResultCode.ERR_TOKEN.getMsg());
	            return result;
	        }
	        
	        // 更新缓存中的update时间,重设超时时间
	        redisDao.set(Consts.REDIS_AUTH_KEY+clientType+":"+uuid,token,Consts.REDIS_TOKEN_EXPIRE_TIME);
			log.info("出参: " + result);
		} catch (Exception e) {
			log.error("token校验异常",e);
			result.setResultCode(ResultCode.SYS_ERROR.getCode());
			result.setResultMsg(ResultCode.SYS_ERROR.getMsg());
			log.info("出参: " + result);
			return result;
		}
		return result;
	}
	/**
	 * 微信openid验证
	 * @Title:        doValidateWx 
	 * @author        guoqh001
	 * @Date          2017年6月26日 下午4:07:56
	 */
	public AuthResultDto doValidateWx(AuthResultDto result,String wxOpenId) {
		log.info("doValidateWx入参: " + wxOpenId);
		if(Tools.isEmpty(wxOpenId)){
			result.setResultCode(ResultCode.NO_WXOPENID.getCode());
			result.setResultMsg(ResultCode.NO_WXOPENID.getMsg());
			return result;
		}
		return null;
	}
	
	public boolean getUserUrlRole(String accessResource,List<String> roleList){
		//校验当前请求是否有权限
		for(String url : roleList){
			if (accessResource.matches(url)) {
				return true;
            }
		}
		return false;
	}

	
	
}
