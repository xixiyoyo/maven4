package com.xixiyoyo2.dao;


import com.xixiyoyo2.domian.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {


  @Select({"select * from orders"})
  @Results(id = "orderMap",value = {
    @Result(id = true,property = "oid",column = "oid"),
    @Result(property = "stime",column = "stime"),
    @Result(property = "total",column = "total"),
    @Result(property = "users",column = "uid",one = @One(select = "com.xixiyoyo2.dao.UsersMapper.findUsersById"))

  })
  public List<Order> findOrder();

  @Select("select * from orders where uid=#{id}")
  public List<Order> findOrderById(int id);
}
