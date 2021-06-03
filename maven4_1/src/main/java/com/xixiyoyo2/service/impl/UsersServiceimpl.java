package com.xixiyoyo2.service.impl;

import com.github.pagehelper.PageHelper;
import com.xixiyoyo2.dao.UsersMapper;
import com.xixiyoyo2.domian.Users;
import com.xixiyoyo2.service.UsersService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UsersServiceimpl implements UsersService {
  @Override
  public List<Users> findUser(int pageNum,int pageSize) {
    List<Users> all = null;
    try {
      InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
      SqlSession sqlSession = sqlSessionFactory.openSession();
      UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
      //分页操作需要在查询前进行
      PageHelper.startPage(pageNum,pageSize);
      all = mapper.findAll();
//      for (Users users : all) {
//        System.out.println(users);
//      }


    } catch (IOException e) {
      e.printStackTrace();
    }

    return all;
  }

  @Override
  public Users findUserCondition(Users users) {
    Users users1 = null;
    try {
      InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
      SqlSession sqlSession = sqlSessionFactory.openSession();
      UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
      users1 = mapper.findAllCondition(users);
      //System.out.println(all);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return users1;
  }

  @Override
  public List<Users> findUserByIds(List<Integer> ids) {
    List<Users> all = null;
    try {
      InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
      SqlSession sqlSession = sqlSessionFactory.openSession();
      UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
      all = mapper.findAllList(ids);
      //System.out.println(all);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return all;
  }
}
