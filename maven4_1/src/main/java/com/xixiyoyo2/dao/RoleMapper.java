package com.xixiyoyo2.dao;

import com.xixiyoyo2.domian.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

  @Select("select * from ru_fk rf,roles r where r.rid = rf.rid and rf.id=#{id}")
  public List<Roles> findAllRoleById(int id);
}
