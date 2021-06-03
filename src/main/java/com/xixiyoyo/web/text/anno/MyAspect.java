package com.xixiyoyo.web.text.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component("myAspect")
@Aspect
public class MyAspect {

  @Before("execution(* com.xixiyoyo.web.text.anno.*.*(..))")
  public void before(){
    System.out.println("前置增强执行");
  }

  @AfterReturning("pointcut()")
  public void after_returning(){
    System.out.println("后置增强");
  }

  @Around("MyAspect.pointcut()")
  public Object arund(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("前置环绕");
    Object proceed = pjp.proceed();
    System.out.println("后置环绕");
    return proceed;
  }
  @AfterThrowing("pointcut()")
  public void throwing(){
    System.out.println("异常抛出增强");
  }


  @After("pointcut()")
  public void after(){
    System.out.println("最终增强");
  }


  @Pointcut("execution(* com.xixiyoyo.web.text.anno.*.*(..))")
  public void pointcut(){}


}
