/**
 * @ClassName     :  SpringContextUtil.java
 * @Description   :  TODO 
 * @author        :  linbj001
 * @version       :  
 * @Date          :  2017年2月22日 下午2:38:16 
 */
package com.nanshan.willow.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author linbj001
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	/**
	 * Spring应用上下文环境
	 */
	private static ApplicationContext applicationContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {
		if (SpringContextUtil.applicationContext == null) {
			SpringContextUtil.applicationContext = applicationcontext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		if (applicationContext != null) {
			return (T) applicationContext.getBean(name);
		}
		return null;
	}
}
