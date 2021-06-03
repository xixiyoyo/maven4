package com.xixiyoyo.service.impl;

import com.xixiyoyo.dao.RolesDao;
import com.xixiyoyo.dao.UsersDao;
import com.xixiyoyo.domain.Roles;
import com.xixiyoyo.domain.Users;
import com.xixiyoyo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceimpl implements UsersService {
  @Autowired
  private UsersDao usersDao;
  @Autowired
  private RolesDao rolesDao;
  @Override
  public List<Users> getUsers() {
    List<Users> usersList = usersDao.getUsersList();
    for (Users users : usersList) {
      List<Roles> rolesList = rolesDao.getRolesByUserId(users.getId());
      users.setRoles(rolesList);
    }
    return usersList;
  }

  @Override
  public Users getUsersById(int id) {
    Users users = usersDao.getUsersById(id);
    return users;
  }

  @Override
  public Users getUsersByName(String name) {
    Users users = usersDao.getUsersByName(name);
    return users;
  }

  @Override
  public int addUsers(Users users) {
    int i = usersDao.addUsers(users);
    return i;
  }

  @Override
  public int delUsers(int id) {
    int i = usersDao.delUsers(id);
    return i;
  }

  @Override
  public int update(Users users) {
    int i = usersDao.updUsers(users);
    return i;
  }

  @Override
  public int addFk(int id, int rid) {
    int i = usersDao.addFk(id, rid);
    return i;
  }

  @Override
  public int delFk(int id) {
    int i = usersDao.delFk(id);
    return i;
  }

  @Override
  public Users isLogin(String name, String password) {
    Users users = usersDao.isLogin(name, password);
    return users;
  }
}
