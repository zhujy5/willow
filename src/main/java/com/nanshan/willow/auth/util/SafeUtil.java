package com.nanshan.willow.auth.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nanshan.willow.common.consts.Consts;
import com.nanshan.willow.common.consts.SysConsts;
import com.nanshan.willow.common.util.CacheManagerUtil;
import com.nanshan.willow.common.util.RedisDao;
import com.nanshan.willow.common.util.Tools;

public class SafeUtil {
	
	private static  Logger log = LoggerFactory.getLogger(SafeUtil.class);
	
	public static boolean getIpSize(String ip,RedisDao redisDao){
		String ipCfg  = CacheManagerUtil.getSysConfig(SysConsts.SERVER_SMS_IP_CFG);
		if(Consts.SMS_IP_CFG.equals(ipCfg)){
			return true;
		}
		String blackKey = Consts.REDIS_SMS_BLACK_KEY+ip;
		try{
			String ipNum = redisDao.get(blackKey);
			if(Tools.isEmpty(ipNum)){
				ipNum = Consts.REDIS_SMS_NUM;
			}
			String ipNumber  = CacheManagerUtil.getSysConfig(SysConsts.SERVER_SMS_IP_NUM);
			if(Tools.notEmpty(ipNumber)){
				ipNumber = Consts.REDIS_SMS_IP_NUM;
			}
			log.debug("当前用户"+ip+"发送次数"+ipNum+"------->短信ip配置发送次数"+ipNumber);
			if(Integer.valueOf(ipNum)>Integer.valueOf(ipNumber)){
				return false;
			}else{
				redisDao.add(blackKey, 1);
				log.debug(blackKey+"失效时间为----"+redisDao.getExpire(blackKey));
				if(redisDao.getExpire(blackKey) > 0){
					redisDao.expire(blackKey,redisDao.getExpire(blackKey));
				}else{
					String ipTime  = CacheManagerUtil.getSysConfig(SysConsts.SERVER_SMS_IP_TIME);
					long time;
					if(Tools.notEmpty(ipTime)){
						 time = Consts.REDIS_SMS_IP_TIME;
					}else{
						time = Long.valueOf(ipTime);
					}
					redisDao.expire(blackKey, time);
				}
			}
		}catch(Exception e){
			log.error(e.getMessage(),e);
			return true;
		}
		return true;
	}
	
	public static boolean getUserAccountSize(String userAccount,RedisDao redisDao){
		String userCfg  = CacheManagerUtil.getSysConfig(SysConsts.SERVER_SMS_USER_CFG);
		if(Consts.SMS_USER_CFG.equals(userCfg)){
			return true;
		}
		String blackKey = Consts.REDIS_SMS_BLACK_KEY+userAccount;
		try{
			String userNum = redisDao.get(blackKey);
			if(Tools.isEmpty(userNum)){
				userNum = Consts.REDIS_SMS_NUM;
			}
			String userNumber  = CacheManagerUtil.getSysConfig(SysConsts.SERVER_SMS_USER_NUM);
			if(Tools.isEmpty(userNumber)){
				userNumber = Consts.REDIS_SMS_USER_NUM;
			}
			log.debug("当前用户"+userAccount+"发送次数"+userNum+"------->短信配置发送次数"+userNumber);
			if(Integer.valueOf(userNum)>Integer.valueOf(userNumber)){
				return false;
			}else{
				redisDao.add(blackKey, 1);
				log.debug(blackKey+"失效时间为----"+redisDao.getExpire(blackKey));
				if(redisDao.getExpire(blackKey) > 0){
					redisDao.expire(blackKey,redisDao.getExpire(blackKey));
				}else{
					String ipTime  = CacheManagerUtil.getSysConfig(SysConsts.SERVER_SMS_USER_TIME);
					long time;
					if(Tools.notEmpty(ipTime)){
						 time = Consts.REDIS_SMS_USER_TIME;
					}else{
						time = Long.valueOf(ipTime);
					}
					redisDao.expire(blackKey, time);
				}
			}
		}catch(Exception e){
			log.error(e.getMessage(),e);
			return true;
		}
		return true;
	}
	
}
