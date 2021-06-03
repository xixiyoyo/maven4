package com.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xixiyoyo2.dao.OrderMapper;
import com.xixiyoyo2.dao.UsersMapper;
import com.xixiyoyo2.domian.Order;
import com.xixiyoyo2.domian.Users;
import com.xixiyoyo2.service.UsersService;
import com.xixiyoyo2.service.impl.UsersServiceimpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Myweb {



  @Test
  public void text1(){
    UsersService us = new UsersServiceimpl();
    List<Users> user = us.findUser(3,2);  //传入分页所需的参数，实现分页。
    for (Users users : user) {
      System.out.println(users);
    }
//    获得与分页相关参数
    PageInfo<Users> pageInfo = new PageInfo<Users>(user);
    System.out.println(pageInfo.getTotal());
    System.out.println(pageInfo.getPages());
//    System.out.println(user);


  }
  @Test
  public void text2(){
    UsersService us = new UsersServiceimpl();
    Users users1 = new Users();
    users1.setName("文软");
    users1.setAge(12);
    Users users = us.findUserCondition(users1);
    System.out.println(users);

  }
  @Test
  public void text3(){
    UsersService us = new UsersServiceimpl();
    List<Integer> ids = new ArrayList<>();
    ids.add(1);
    ids.add(2);
    List<Users> usersList = us.findUserByIds(ids);
    System.out.println(usersList);

  }
  @Test
  public void text4() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    List<Order> order = mapper.findOrder();
    System.out.println(order);

  }
  @Test
  public void text5() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
    List<Users> usersList = mapper.findAllUsers();
    for (Users users : usersList) {
      System.out.println(users);
    }

  }
  @Test
  public void text6() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    List<Order> order = mapper.findOrder();
    for (Order users : order) {
      System.out.println(users);
    }

  }
  @Test
  public void text7() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
    List<Users> allAndOrder = mapper.findUserAllAndOrder();
    for (Users users : allAndOrder) {
      System.out.println(users);
    }

  }
  @Test
  public void text8() throws IOException {
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
    List<Users> allAndRole = mapper.findUserAllAndRole();
    for (Users users : allAndRole) {
      System.out.println(users);
    }

  }


}
