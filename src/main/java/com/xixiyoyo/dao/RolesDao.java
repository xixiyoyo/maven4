package com.xixiyoyo.dao;

import com.xixiyoyo.domain.Roles;

import java.util.List;

public interface RolesDao {

  public List<Roles> getRoles();

  List<Roles> getRolesByUserId(int UserId);
}
