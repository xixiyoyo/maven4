package com.xixiyoyo.web.text.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
  public void before(){
    System.out.println("前置增强执行");
  }
  public void after_returning(){
    System.out.println("后置增强");
  }
  public Object arund(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("前置环绕");
    Object proceed = pjp.proceed();
    System.out.println("后置环绕");
    return proceed;
  }
  public void throwing(){
    System.out.println("异常抛出增强");
  }
  public void after(){
    System.out.println("最终增强");
  }


}
