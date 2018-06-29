package com.nanshan.willow.auth.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.nanshan.willow.auth.dto.AuthFilterContext;
import com.nanshan.willow.auth.dto.AuthResultDto;
import com.nanshan.willow.auth.dto.TokenValidateForm;
import com.nanshan.willow.auth.service.RestAuthFilterHandler;
import com.nanshan.willow.common.consts.Consts;
import com.nanshan.willow.common.consts.SysConsts;
import com.nanshan.willow.common.util.CacheManagerUtil;
import com.nanshan.willow.common.util.RedisDao;
import com.nanshan.willow.common.util.TokenUtil;

/**
 * 
 * @ClassName:  RestAuthFilterHandlerImpl   
 * @Description: token校验
 * @author: zhujy001
 * @date:   2018年2月10日 下午3:33:33
 *
 */
@Service
public class RestAuthFilterHandlerImpl implements RestAuthFilterHandler {

	private static Logger log = LoggerFactory.getLogger(RestAuthFilterHandlerImpl.class);
	
	@Autowired
	RedisDao redisDao;
	
	
    @Override
    public boolean shouldBeHandle(AuthFilterContext context) {
    	//认证开关 如果全局认证开关是关闭的，则该过滤器无需进行后续的token认证等相关逻辑
        if (isAuthOff()) {
            return false;
        }
        String serverUrl = context.getServerUrl();
        // 白名单 如果包含不需要认证的，返回false
        List<String> whitelist = CacheManagerUtil.getWhiteList();
        if(whitelist.isEmpty()){
        	return true;
        }
        for(String white : whitelist){
        	if (serverUrl.matches(white)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断当前认证开关是否关闭 
     * 
     * @Title: isAuthOff
     * @author linbj001
     * @Date 2017年3月16日 下午4:22:58
     */
    private boolean isAuthOff() {
        // 0开启，1关闭
    	String authCfg = CacheManagerUtil.getSysConfig(SysConsts.SYS_CONF_AUTHCFG); 
        return Consts.AUTH_TOKEN_CFG.equals(authCfg);
    }

    @Override
    public TokenValidateForm decodeValidateForm(AuthFilterContext context) {
        // 获取 token
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        String token = request.getHeader("token");

        // 校验token
        TokenUtil.verifyToken(token);

        // 返回token
        TokenValidateForm form = new TokenValidateForm();
        form.setToken(token);
        form.setAccessResource(request.getServletPath());
        log.debug("token-------------"+token+"=========="+"request.getServletPath()====="+request.getServletPath());
        return form;
    }

    @Override
    public void whenNotAuth(AuthFilterContext context) {
    	 HttpServletResponse response = (HttpServletResponse) context.getResponse();
         JSONObject returnJson = new JSONObject();
         returnJson.put(Consts.RESCODE, "1001");
         returnJson.put(Consts.RESMSG, "[1001]非法请求【未授权】当前用户未登录或者登录超时，请重新登录");
         sendResponseJson(response, returnJson.toString());
    }

    @Override
    public void whenValidateResult(AuthFilterContext context, TokenValidateForm form, AuthResultDto result) {
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        if (!"0".equals(result.getResultCode())) {
        	//判断无操作权限，直接返回
        	if("0005".equals(result.getResultCode())){
        		// 如果鉴权失败直接返回错误码终止服务
        		JSONObject returnJson = new JSONObject();
        		returnJson.put(Consts.RESCODE, "1004");
        		returnJson.put(Consts.RESMSG, "[1004]鉴权失败【%s】"+result.getResultMsg());
        		sendResponseJson(response, returnJson.toString());
        		return;
        	}
            // 如果鉴权失败直接返回错误码终止服务
        	 JSONObject returnJson = new JSONObject();
             returnJson.put(Consts.RESCODE, "1002");
             returnJson.put(Consts.RESMSG, "[1002]鉴权失败【%s】"+result.getResultMsg());
             sendResponseJson(response, returnJson.toString());
        } else {
            try {
                // 如果鉴权成功走后续流程
                context.getFilterChain().doFilter(context.getRequest(), context.getResponse());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JSONObject returnJson = new JSONObject();
                returnJson.put(Consts.RESCODE, "1003");
                returnJson.put(Consts.RESMSG, "[1003]系统发生异常，请联系管理员！");
                sendResponseJson(response, returnJson.toString());
                
            }
        }
    }
    
    public  void sendResponseJson(HttpServletResponse response, String json) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			log.info("sendResponseJson_json:" + json);
			response.getWriter().write(json);
		} catch (IOException e) {
			log.error("send response to client error: json content is " + json,e);
		}
	}

}
