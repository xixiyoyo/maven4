package com.xixiyoyo.service.impl;

import com.xixiyoyo.dao.impl.RolesDaoimpl;
import com.xixiyoyo.domain.Roles;
import com.xixiyoyo.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceimpl implements RolesService {
  @Autowired
  private RolesDaoimpl rolesDaoimpl;
  @Override
  public List<Roles> queryRoles() {
    List<Roles> rolesList = rolesDaoimpl.getRoles();
    return rolesList;
  }
}
