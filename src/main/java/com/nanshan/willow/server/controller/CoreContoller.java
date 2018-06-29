package com.nanshan.willow.server.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nanshan.willow.auth.controller.LoginController;
import com.nanshan.willow.common.util.ResultDto;

@Controller
@RequestMapping(value="/wx")
public class CoreContoller {

	private static Logger log = LoggerFactory.getLogger(CoreContoller.class);
	
	/**
	 * 登陆
	 * @Title:        appLogin 
	 * @author        guoqh001
	 * @Date          2017年6月19日 上午9:10:08
	 */
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto appLogin(@RequestBody Map<String,Object> param){
		log.debug("tets拦截测试------"+param);
		ResultDto result = new ResultDto();
		
		return result;
	}
}
