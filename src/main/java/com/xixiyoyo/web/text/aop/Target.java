package com.xixiyoyo.web.text.aop;

public class Target implements TargetInterface{
  @Override
  public void save() {
    System.out.println("保存方法执行！！！");
  }
}
