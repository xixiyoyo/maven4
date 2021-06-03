package com.xixiyoyo2.service;

import com.xixiyoyo2.domian.Users;

import java.util.List;

public interface UsersService {

  public List<Users> findUser(int pageNum,int pageSize);
  public Users findUserCondition(Users users);
  public List<Users> findUserByIds(List<Integer> ids);

}
