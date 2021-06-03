package com.xixiyoyo.dao.impl;

import com.xixiyoyo.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoimpl implements UserDao {
  @Override
  public void save() {
    System.out.println("save money.....");
  }
}
