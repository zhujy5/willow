package com.nanshan.willow.common.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDao {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	private ValueOperations<String, String> valueOper;
	
	@Autowired
	private RedisTemplate<String, List<String>> redisTemp;

	private ValueOperations<String, List<String>> valueOp;
	
	/**
	 *  存redis,key ,value,失效时间
	 * @Title:        set 
	 * @author        guoqh001
	 * @Date          2017年6月20日 上午10:02:57
	 */
	public void set(String key,String value,Long time) {
		getValueOper().set(key,value, time, TimeUnit.SECONDS);
	}
	
	public void set(String key,String value) {
		getValueOper().set(key,value);
	}
	
	/**
	 * 每次加1
	 * @Title:        add 
	 * @author        guoqh001
	 * @Date          2017年7月21日 下午5:36:25
	 */
	public void add(String key,Integer value) {
		getValueOper().increment(key,value);
	}
	
	/**
	 * 设置失效时间
	 * @Title:        expire 
	 * @author        guoqh001
	 * @Date          2017年7月21日 下午5:35:36
	 */
	public  void expire(String key,Long time) {
		RedisOperations<String, String> redisOperations = getValueOper().getOperations();
		redisOperations.expire(key, time, TimeUnit.SECONDS);
	}
	/**
	 * 获取失效时间
	 * @Title:        expire 
	 * @author        guoqh001
	 * @Date          2017年7月21日 下午5:35:36
	 */
	public Long getExpire(String key) {
		RedisOperations<String, String> redisOperations = getValueOper().getOperations();
		return redisOperations.getExpire(key);
	}
	/**
	 * 获取key是否存在
	 * @Title:        hasKey 
	 * @author        guoqh001
	 * @Date          2017年10月11日 下午5:03:21
	 */
	public boolean hasKey(String key) {
		RedisOperations<String, String> redisOperations = getValueOper().getOperations();
		return redisOperations.hasKey(key);
	}
	
	public ValueOperations<String, String> getValueOper() {
		if (valueOper == null) {
			valueOper = redisTemplate.opsForValue();
		}
		return valueOper;
	}
	
	public ValueOperations<String, List<String>> getValue() {
		if (valueOp == null) {
			valueOp = redisTemp.opsForValue();
		}
		return valueOp;
	}
	
	public String get(String key) {
		return getValueOper().get(key);
	}
	
	public void delete(String key){
		RedisOperations<String, String> redisOperations = getValueOper().getOperations();
		redisOperations.delete(key);
	}
	
	public void setListkey(String key,List<String> value) {
		getValue().set(key,value);
	}
	
	public List<String> getListValue(String key){
		return getValue().get(key);
	}
	
	
}
