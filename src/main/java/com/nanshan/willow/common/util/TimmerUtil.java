package com.nanshan.willow.common.util;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nanshan.willow.common.consts.SysConsts;

public class TimmerUtil {
	
	private static Logger log=LoggerFactory.getLogger(TimmerUtil.class);

	private static String isBatchServer = null;
	
	public static boolean checkIsBatchServer(){
		String batchServerIp = CacheManagerUtil.getSysConfig(SysConsts.SERVER_TIMMER_PERMISSION_IP);
		if(isBatchServer!=null&&!"".equals(isBatchServer)){
			return "true"==isBatchServer;
		}
		String localIp="";
		try {
			localIp = InetAddress.getLocalHost().getHostAddress();
			log.info("服务器ip地址-------"+localIp+"批处理服务器地址："+batchServerIp);
			if(batchServerIp!=null&&!"".equals(batchServerIp)&&localIp!=null){
				if(batchServerIp.equals(localIp)){
					isBatchServer = "true";
					log.info("本机服务器属于批处理服务器！");
					return true;
				}else{
					isBatchServer = "false";
					log.info("本机服务器不属于批处理服务器！");
					return false;
				}
			}
		} catch (Exception e) {
			log.error("获取ip失败",e);
		}
		return false;
	}
	
	
//	public static String checkTimmerIp(){
//		String localIp="";
//		try {
//			localIp = InetAddress.getLocalHost().getHostAddress();
//			log.info("能服务器批处理ip地址-------------------->"+localIp);
//		} catch (Exception e) {
//			log.error("获取ip失败",e);
//		}
//		if(!timmerIp.equals(localIp)){
//			log.info("-------------批处理由"+timmerIp+"服务器处理----------，本机不能执行timmer");
//			return Consts.RESULT_CODE_ERROR;
//		}
//		return Consts.RESULT_CODE_SUCCESS;
//	}
}
