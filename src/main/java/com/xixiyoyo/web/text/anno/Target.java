package com.xixiyoyo.web.text.anno;

import com.xixiyoyo.web.text.anno.TargetInterface;
import org.springframework.stereotype.Component;


@Component("target")
public class Target implements TargetInterface {
  @Override
  public void save() {
    System.out.println("保存方法执行！！！");
  }
}
