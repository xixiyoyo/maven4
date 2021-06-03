package com.xixiyoyo.dao;

import com.xixiyoyo.domain.Users;

import java.util.List;

public interface UsersDao {

  public List<Users> getUsersList();
  public Users getUsersById(int id);
  public Users getUsersByName(String name);
  public int addUsers(Users users);
  public int delUsers(int id);
  public int updUsers(Users users);
  public int addFk(int id,int rid);
  public int delFk(int id);
  public Users isLogin(String name,String password);
}
