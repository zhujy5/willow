package com.nanshan.willow.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * aop代理
 * @author zhujy001
 */
@Aspect  
public class LogAnnotationAspect {

		/**
		 *  @Pointcut定义切入点，提供一个方法，这个方法的名字就是改切入点的id
		 *  @Before针对指定的切入点表达式选择的切入点应用前置通知
		 */
	    @Pointcut("execution(* com.nanshan.willow.auth.controller.*.*(..))")  
	    private void allMethod(){}  
	    @Before("allMethod()")
	    public void before(JoinPoint call) {  
	        String className = call.getTarget().getClass().getName();
	        String methodName = call.getSignature().getName();
	        System.out.println("开始执行:"+className+"."+methodName+"()方法...");
	    }
		 /**
		 *访问命名切入点来应用后置通知
		 */
	    @AfterReturning("allMethod()")
	    public void afterReturn(JoinPoint call) {  
	        String className = call.getTarget().getClass().getName();
	        String methodName = call.getSignature().getName();
	        System.out.println(className+"."+methodName+"()方法正常执行结束...");
	    }  
		/**
		 *应用最终通知
		 */
	    @After("allMethod()")  
	    public void after(JoinPoint call) {  
	        String className = call.getTarget().getClass().getName();
	        String methodName = call.getSignature().getName();
	        System.out.println(className+"."+methodName+"()最终执行步骤(finally)...");
	    }

		/**
		 * 应用异常抛出后通知
		 * @param call
		 */
	    @AfterThrowing("allMethod()")
	    public void afterThrowing(JoinPoint call) {  
	        String className = call.getTarget().getClass().getName();
	        String methodName = call.getSignature().getName();
	        System.out.println(className+"."+methodName+"()方法抛出了异常...");
	    }  

		/**
		 * 应用周围通知
		 * @Around("allMethod()")
		 * @param call
		 * @return
		 * @throws Throwable
		 */
	    public Object doAround(ProceedingJoinPoint call) throws Throwable{  
	        Object result = null;
			//相当于前置通知
			this.before(call);
	        try {
	            result = call.proceed();
				//相当于后置通知
				this.afterReturn(call);
	        } catch (Throwable e) {
				//相当于异常抛出后通知
				this.afterThrowing(call);
	            throw e;
	        }finally{
				//相当于最终通知
				this.after(call);
	        }
	        return result;  
	    }  
}
