package com.nanshan.willow.aop;

import org.aspectj.lang.JoinPoint;

public class LogAop {
    public void before(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println("开始执行:" + className + "." + methodName + "()方法...");
    }

    public void afterThrowing(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println(className + "." + methodName + "()方法抛出了异常...");
    }

    public void afterReturn(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println(className + "." + methodName + "()方法正常执行结束...");
    }

    public void after(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        /*System.out.println(className+"."+methodName+"()最终执行步骤(finally)...");*/
        System.out.println(className + "." + methodName + "()最终执行步骤(finally)...");
    }
}
