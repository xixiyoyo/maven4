package com.xixiyoyo.dao.impl;

import com.xixiyoyo.dao.UsersDao;
import com.xixiyoyo.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsersDaoimpl implements UsersDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Users> getUsersList() {
    List<Users> usersList = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<Users>(Users.class));

    return usersList;
  }

  @Override
  public Users getUsersById(int id) {
    List<Users> usersList = jdbcTemplate.query("select * from users where id=?",new BeanPropertyRowMapper<Users>(Users.class),id);
    if(usersList.size() > 0){
       Users users = usersList.get(0);
       return users;
    }
    return null;
  }

  @Override
  public Users getUsersByName(String name) {
    List<Users> usersList = jdbcTemplate.query("select * from users where name=?",new BeanPropertyRowMapper<Users>(Users.class),name);
    if(usersList.size() > 0){
      Users users = usersList.get(0);
      return users;
    }
    return null;
  }

  @Override
  public int addUsers(Users users) {
    int add = jdbcTemplate.update("insert into users (name,password,age) value (?,?,?)", users.getName(), users.getPassword(), users.getAge());
    return add;
  }

  @Override
  public int delUsers(int id) {
    int del = jdbcTemplate.update("delete from users where id=?", id);
    return del;

  }

  @Override
  public int updUsers(Users users) {
    int update = jdbcTemplate.update("update users set name=?,password=?,age=?,role=? where id=?", users.getName(), users.getPassword(), users.getAge(), users.getRole(), users.getId());
    return update;
  }

  @Override
  public int addFk(int id, int rid) {
    int add = jdbcTemplate.update("insert into ru_fk value (?,?)",id,rid);
    return add;
  }

  @Override
  public int delFk(int id) {
    int update = jdbcTemplate.update("delete from ru_fk where id=?", id);
    return update;
  }

  @Override
  public Users isLogin(String name, String password) {
    List<Users> query = jdbcTemplate.query("select * from users where name=? and password=?", new BeanPropertyRowMapper<>(Users.class), name, password);
    if(query.size() > 0){
      Users users = query.get(0);
      return users;
    }
    return null;
  }
}
