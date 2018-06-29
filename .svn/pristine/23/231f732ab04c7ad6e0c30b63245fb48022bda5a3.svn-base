package com.nanshan.willow.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.nanshan.willow.auth.entity.SysConfig;
import com.nanshan.willow.auth.service.AuthService;
import com.nanshan.willow.common.consts.Consts;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 
 * @ClassName:  CacheMangerUtil   
 * @Description:jvm缓存
 * @author: guoqh001
 * @date:   2017年7月4日 下午3:16:00   
 *
 */
public class CacheManagerUtil {

	private static Logger log = LoggerFactory.getLogger(CacheManagerUtil.class);
	
	private static JSONObject json = new JSONObject();
	
	private static Ehcache dictParamCache = (Ehcache) SpringContextUtil.getBean("dictParamCache");
	
	private static Ehcache tradeCache = (Ehcache) SpringContextUtil.getBean("tradeCache");
	
	private static AuthService authService = (AuthService) SpringContextUtil.getBean("authService");
	
	private CacheManagerUtil(){}
	
	/**
	 * 读取系统配置
	 * @Title:        getSysConfig 
	 * @author        guoqh001
	 * @Date          2017年7月5日 上午10:23:03
	 */
	@SuppressWarnings("unchecked")
	public static String getSysConfig(String key){
		String value = "";
		Map<String,String> sysMap = null;
		Element element = dictParamCache.get(Consts.Willow_CORE_SYS_CONFIG);
        if (element != null) {
            Object obj = element.getObjectValue();
            sysMap = (Map<String,String>) obj;
        } 
        if(sysMap == null){
        	try{
        		List<SysConfig> sysList = authService.selectSysConfig();
        		sysMap = new HashMap<String, String>();
            	if(!sysList.isEmpty()){
            		for(SysConfig sys : sysList){
            			sysMap.put(sys.getConfKey(), sys.getConfValue());
             		}
            		dictParamCache.put(new Element(Consts.Willow_CORE_SYS_CONFIG,sysMap));
            		setCacheJson(Consts.Willow_CORE_SYS_CONFIG, "系统配置");
            	}
        	}catch(Exception e){
        		log.error("获取配置异常",e);
        		return value;
        	}
        }
        if(!sysMap.isEmpty() ){
        	value = sysMap.get(key);
        }
		return value;
	}
	/**
	 * 获取白名单
	 * @Title:        getWhiteList 
	 * @author        guoqh001
	 * @Date          2017年7月5日 上午10:30:57
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getWhiteList(){
		List<String> whiteList = null;
		Element element = dictParamCache.get(Consts.BBPARK_CORE_AUTH_WHITELIST);
        if (element != null) {
            Object obj = element.getObjectValue();
            whiteList = (List<String>) obj;
        } 
        if(whiteList == null){
        	try{
        		whiteList = authService.selectWhitelist();
        		if(whiteList != null){
        			dictParamCache.put(new Element(Consts.BBPARK_CORE_AUTH_WHITELIST,whiteList));
        			setCacheJson(Consts.BBPARK_CORE_AUTH_WHITELIST, "认证白名单");
        		}
        	}catch(Exception e){
        		log.error("获取白名单异常",e);
        		return whiteList;
        	}
        }
        log.debug("白名单配置"+whiteList);
		return whiteList;
	}
	
	
	/**
	 * 获取权限列表
	 * @Title:        getRoleList 
	 * @author        guoqh001
	 * @Date          2017年7月5日 下午7:57:50
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getRoleList(String roleCode){
		List<String> roleList = null;
		Element element = dictParamCache.get(Consts.AUTH_TOKEN_ROLE_KEY + "_" + roleCode);
        if (element != null) {
            Object obj = element.getObjectValue();
            roleList = (List<String>) obj;
        } 
        if(roleList == null){
        	 try {
	            	roleList = authService.selectUserRoleUrl(roleCode);
	                if(!roleList.isEmpty()) {
	                	dictParamCache.put(new Element(Consts.AUTH_TOKEN_ROLE_KEY + "_" + roleCode, roleList));
	                	setCacheJson(Consts.AUTH_TOKEN_ROLE_KEY + "_" + roleCode, roleCode+"角色权限");
	                }
	            } catch (Exception ex) {
	                log.error(ex.getMessage(), ex);
	            }
        }
		return roleList;
	}
	
	
	public static JSONObject getCacheJson() {
		// 判断缓存中是否包含缓存json的key，如果包含，则从缓存中取，否则返回初始json
		if (dictParamCache.getKeys().contains(Consts.BBPARK_CORE_CACHE_MAP_KEY)) {
			Element element = dictParamCache.get(Consts.BBPARK_CORE_CACHE_MAP_KEY);
			json =  (JSONObject) element.getObjectValue();
		}
		return json;
	}

	/**
	 * 将对象存入缓存map，并且将map存入缓存，以保证和缓存中的对象保持同步
	 * 
	 * @param key
	 * @param value
	 */
	public static void setCacheJson(String key, String value) {
		json.put(key, value);
		dictParamCache.put(new Element(Consts.BBPARK_CORE_CACHE_MAP_KEY, json));
	}
	
	
	/**
	 * 报表模块，根据key放入对象
	 * 
	 */
	public static void setTradeValue(String key, List<Map<String,Object>> value){
		Element e = new Element(key,value);
		tradeCache.put(e);
	}
	//获取值
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> getTradeValue(String key){
		Element element = tradeCache.get(key);
		if(element==null){
			return null;
		}
		Object obj = element.getObjectValue();
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		Map<String,Object> dataStr;
		if (obj instanceof List) {
			dataList = (List<Map<String,Object>>) obj;
		}

		if (obj instanceof Map) {
			dataStr = (Map<String,Object>) obj;
			dataList.add(dataStr);
		}

		return dataList;
	}
	
	
	
	/**
	 * 通过缓存Key删除map和缓存中的特定对象
	 * 
	 * @param cachekey
	 * @return
	 */
	public static boolean deleteCacheObject(String cachekey) {
		json.remove(cachekey);
		return dictParamCache.remove(cachekey);
	}
	
	/**
	 * 获取缓存对象信息
	 * 
	 * @param cachekey
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getCacheObject(String cachekey) {
		Element element = dictParamCache.get(cachekey);
		Object obj = element.getObjectValue();
		List<String> dataList = new ArrayList<String>();
		String dataStr;
		if (obj instanceof List) {
			dataList = (List<String>) obj;
		}

		if (obj instanceof String) {
			dataStr = (String) obj;
			dataList.add(dataStr);
		}

		return dataList;
	}
	
	
	
}
