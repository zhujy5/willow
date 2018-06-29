package com.nanshan.willow.auth.dto;


import com.alibaba.fastjson.JSON;

public class JsonDto {
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
