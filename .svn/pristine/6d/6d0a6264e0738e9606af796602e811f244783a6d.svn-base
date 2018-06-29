package com.nanshan.willow.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName:  IpUtil   
 * @Description: 获取ip   
 * @author: guoqh001
 * @date:   2017年8月2日 下午2:46:35   
 *
 */
public class IpUtil {
	
	private static Logger log = LoggerFactory.getLogger(IpUtil.class);
	
	private static final String UNKNOWN = "unknown";	
	
	/**
     * 获取远程ip
     * @Title:        getIpAddr 
     * @author        guoqh001
     * @Date          2017年8月2日 下午2:44:59
     */
    public static String getIpAddr(HttpServletRequest request) {
    	log.info(request.getRequestURL()+"");
		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			log.info(key + " = " + value);
		}
        String ip = request.getHeader("x-forwarded-for");
        if(Tools.notEmpty(ip)){
        	String[] ipList = ip.split(",");
        	ip = ipList[0];
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
