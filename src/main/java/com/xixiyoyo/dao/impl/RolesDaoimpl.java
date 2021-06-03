package com.xixiyoyo.dao.impl;

import com.xixiyoyo.dao.RolesDao;
import com.xixiyoyo.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RolesDaoimpl implements RolesDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Override
  public List<Roles> getRoles() {
    List<Roles> rolesList = jdbcTemplate.query("select * from roles", new BeanPropertyRowMapper<>(Roles.class));
    return rolesList;
  }

  @Override
  public List<Roles> getRolesByUserId(int userId) {
    List<Roles> rolesList = jdbcTemplate.query("select r.rid,rname,rdesc from ru_fk f,roles r where f.rid=r.rid and f.id=?", new BeanPropertyRowMapper<>(Roles.class), userId);
    return rolesList;
  }
}
