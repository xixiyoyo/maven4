package com.xixiyoyo.service.impl;

import com.xixiyoyo.dao.UserDao;
import com.xixiyoyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")     //@Service相当于Bean的功能，将对象注入Spring容器
public class UserServiceimpl implements UserService {
  @Autowired
  @Qualifier("userDao")
  private UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void usersave() {
    userDao.save();
  }
}
