package com.xixiyoyo2.dao;

import com.xixiyoyo2.domian.Users;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {

  public List<Users> findAll();
  public Users findAllCondition(Users users);  //多条件查询
  public List<Users> findAllList(List<Integer> ids);
  public List<Users> findAllUsers();   //多表查询

  @Select("select * from users where id=#{id}")
  public Users findUsersById(int id);


  @Select("select * from users")
  @Results(id = "usersMap",value = {
    @Result(id = true,property = "id",column = "id"),
    @Result(property = "name",column = "name"),
    @Result(property = "password",column = "password"),
    @Result(property = "age",column = "age"),
    @Result(property = "role",column = "role"),
    @Result(property = "orders",column = "id",many = @Many(select = "com.xixiyoyo2.dao.OrderMapper.findOrderById"))


  })
  public List<Users> findUserAllAndOrder();


  @Select("select * from users")
  @Results(id = "userMapRole",value = {
    @Result(id = true,property = "id",column = "id"),
    @Result(property = "name",column = "name"),
    @Result(property = "password",column = "password"),
    @Result(property = "age",column = "age"),
    @Result(property = "role",column = "role"),
    @Result(property = "roles",column = "id",many = @Many(select = "com.xixiyoyo2.dao.RoleMapper.findAllRoleById"))


  })
  public List<Users> findUserAllAndRole();
}
