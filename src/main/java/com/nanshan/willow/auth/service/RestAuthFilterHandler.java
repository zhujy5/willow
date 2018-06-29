package com.nanshan.willow.auth.service;

import com.nanshan.willow.auth.dto.AuthFilterContext;
import com.nanshan.willow.auth.dto.AuthResultDto;
import com.nanshan.willow.auth.dto.TokenValidateForm;

/**
 * 授权客户端Filter的Rest回调接口
 * @author maozk001
 *
 */
public interface RestAuthFilterHandler{
	
	/**
	 * 该请求是否应该被处理
	 * @param context
	 * @return
	 */
	boolean shouldBeHandle(AuthFilterContext context);
	
	
	/**
	 * 从请求中获取授权表单
	 * @param request
	 * @param response
	 * @return
	 */
	TokenValidateForm decodeValidateForm(AuthFilterContext context);
	
	/**
	 * 当请求没有被授权
	 * @param context
	 */
	void whenNotAuth(AuthFilterContext context);
	
	/**
	 * 当收到授权结果时的回调处理
	 * @param result
	 * @param request
	 * @param response
	 */
	void whenValidateResult(AuthFilterContext context,TokenValidateForm form,AuthResultDto result);
	
}
