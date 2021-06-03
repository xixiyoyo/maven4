package com.test;

import com.xixiyoyo.web.text.aop.Target;
import com.xixiyoyo.web.text.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class AopTest {

  @Autowired
  private TargetInterface targetInterface;

  @Test
  public void text1(){
    targetInterface.save();
  }




}
