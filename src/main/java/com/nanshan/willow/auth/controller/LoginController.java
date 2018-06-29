package com.nanshan.willow.auth.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.nanshan.willow.auth.dto.UserInfo;
import com.nanshan.willow.auth.entity.User;
import com.nanshan.willow.auth.service.UserAuthService;
import com.nanshan.willow.common.consts.Consts;
import com.nanshan.willow.common.util.RedisDao;
import com.nanshan.willow.common.util.ResultDto;
import com.nanshan.willow.common.util.TokenUtil;
import com.nanshan.willow.common.util.Tools;

/**
 * 
 * @ClassName:  LoginController   
 * @Description:登陆注册  
 * @author: zhujy001
 * @date:   2018年2月10日 下午3:33:33
 *
 */
@Controller
@RequestMapping(value="/auth")
public class LoginController {
	


	private static final String USER_RELEVANCE = "userRelevanceId";

	private static final String TOKEN = "token";

	private static final String PASS_WORD = "password";

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private static final String USER_ACCOUNT = "userAccount";

	@Autowired
	UserAuthService userService;
	
	@Autowired
	RedisDao redisDao;
	
	/**
	 * 登陆
	 * @Title:        appLogin 
	 * @author        guoqh001
	 * @Date          2017年6月19日 上午9:10:08
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto appLogin(@RequestBody Map<String,Object> param){
		log.debug("applogin登录入参------"+param);
		ResultDto result = new ResultDto();
		Map<String, Object> data = new HashMap<String, Object>();
		String userAccount = MapUtils.getString(param, USER_ACCOUNT);
		String password = MapUtils.getString(param, PASS_WORD);
		String macAddress = MapUtils.getString(param, "macAddress");
		String mobileBrand = MapUtils.getString(param, "mobileBrand");
		String mobileSystem = MapUtils.getString(param, "mobileSystem");
		if(Tools.isEmpty(userAccount) || Tools.isEmpty(password)){
			result.setResultMsg("用户名或密码为空，请重新输入！");
			result.setResultCode(Consts.RESULT_CODE_ERROR);
			return  result;
		}
		User userinfo = userService.getPasswordInfo(userAccount);
		if (userinfo == null) {
            result.setResultCode(Consts.RESULT_CODE_ERROR);
            result.setResultMsg("账号不存在，请确认账号是否输入正确");
            return result;
        }
		log.debug(JSONObject.toJSON(userinfo)+"");
		String uuid = userinfo.getUserRelevanceId();
		ResultDto resultDto = checkUserInfo(password,userinfo);
		if(resultDto != null){
			return resultDto;
		}
		//密码错误次数清零以及设备信息
		User user = new User();
		user.setUserAccount(userAccount);
		user.setMacAddress(macAddress);
		user.setMobileBrand(mobileBrand);
		user.setMobileSystem(mobileSystem);
		try{
			userService.updatePasswordNum(user);
			String roleCode = userinfo.getRoleCode();
			String token = creatToken(uuid,null,Consts.Willow_CLIENT_TYPE_APP,
					Consts.REDIS_AUTH_KEY+Consts.TOKEN_CLIENT_TYPE_APP+uuid,roleCode);
			data.put(TOKEN, token);
			data.put(USER_RELEVANCE, uuid);
			result.setData(data);
		}catch(Exception e){
			result.setResultCode(Consts.RESULT_CODE_ERROR);
			result.setResultMsg("登录异常");
			log.error("登录异常",e);
		}
		log.debug("app登录出参"+result);
		return result;
	}
	
	
	
	
	/**
	 * 登录校验
	 * @Title:        checkUserInfo 
	 * @author        guoqh001
	 * @Date          2017年6月28日 下午2:42:43
	 */
    public ResultDto checkUserInfo(String password,User userinfo) {
    	ResultDto result = new ResultDto();
        String dbPassword = userinfo.getPassword();
        int passwordTryNum = userinfo.getPasswordTryNum();
        String userStatus = userinfo.getUserStatus();
        String passswordStatus = userinfo.getPasswordStatus();
        
        if(Consts.USER_PASSWOED_STATUS.equals(passswordStatus)){
        	result.setResultCode(Consts.RESULT_CODE_ERROR);
        	result.setResultMsg("当前密码已被锁定，请重置密码");
        	return result;
        }
        
        if(Consts.USER_USERACCOUNT_STATUS.equals(userStatus)){
        	result.setResultCode(Consts.RESULT_CODE_ERROR);
        	result.setResultMsg("当前账号已被锁定，请联系管理员申请解冻!");
        	return result;
        }
        
        if (!password.equals(dbPassword)) {
            // 如果客户端传过来的密码和数据库中密码不一致，则说明密码错误
        	 result.setResultCode(Consts.RESULT_CODE_ERROR);
            if (passwordTryNum >= 4) {
            	result.setResultMsg("密码输入错误！您的密码输入次数已经达到5次，\n账号已被锁定，请找回密码后重新登陆。");
            } else {
            	result.setResultMsg("密码输入错误！您已经输错" + (passwordTryNum + 1) + "次,错误达到5次将被锁定。");
            }
            // 数据库给密码错误次数加一
            userService.updatePasswordSize(userinfo.getUserRelevanceId());
            return result;
        }

        if (passwordTryNum >= 5) {
            // 如果尝试次数已经超过5次，则账号锁定不能登录
            result.setResultCode(Consts.RESULT_CODE_ERROR);
            result.setResultMsg("您的密码错误次数已经达到5次，账号被锁，请找回密码后重新登陆。");
            return result;
        }
        return null;
    }
    /**
     * 创建token
     * @Title:        creatToken 
     * @author        guoqh001
     * @Date          2017年6月28日 下午2:42:56
     */
    public String creatToken(String uuid,String wxOpenId,String clientType,String key,String roleCode){
    	UserInfo userInfo = new UserInfo();
		userInfo.setUserRelevanceId(uuid);
		if(Tools.notEmpty(wxOpenId)){
			userInfo.setWxOpenId(wxOpenId);
		}
		if(Tools.notEmpty(clientType)){
			userInfo.setClientType(clientType);
		}
		if(Tools.notEmpty(roleCode)){
			userInfo.setRoleCode(roleCode);
		}
		userInfo.setCreateDate(new Date(System.currentTimeMillis()));
		//生成token
		String token = TokenUtil.createToken(userInfo);
		if(Tools.notEmpty(token)){
			//将token放入redis中 一个礼拜失效
			redisDao.set(key, token,Consts.REDIS_TOKEN_EXPIRE_TIME);
		}
		return token;
    }
   
}
