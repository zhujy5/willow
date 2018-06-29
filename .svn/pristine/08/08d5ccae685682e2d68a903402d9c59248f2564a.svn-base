package com.nanshan.willow.auth.dto;

import java.util.HashMap;
import java.util.Map;

import com.nanshan.willow.common.consts.Consts;


public class AuthResultDto extends JsonDto {
	/**
	 * 0: 成功
	 */
	private String resultCode = Consts.RESULT_CODE_SUCCESS;

	/*
	 * 结果描述
	 */
	private String resultMsg = Consts.RESULT_CODE_SUCCESS_MSG;
	
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
