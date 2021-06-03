package com.test;

import com.xixiyoyo.domain.User;
import com.xixiyoyo.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


  @Test
  public void text4() throws IOException {

    Users users = new Users(5,"jis","qwer1234",21,1);
    //获得核心配置文件
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //获得session工厂对象
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //获得session会话对象
    SqlSession sqlSession = sessionFactory.openSession();
    //执行操作 参数：namespace+id
    int delete = sqlSession.delete("userMapper.delete",5);
    System.out.println(delete);
    //Mybatis执行更新操作 提交事务（Mybatis默认不提交与jdbc不同）
    sqlSession.commit();
    //释放资源
    sqlSession.close();
  }


  @Test
  public void text3() throws IOException {

    Users users = new Users(5,"jis","qwer1234",21,1);
    //获得核心配置文件
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //获得session工厂对象
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //获得session会话对象
    SqlSession sqlSession = sessionFactory.openSession();
    //执行操作 参数：namespace+id
    int update = sqlSession.update("userMapper.update", users);
    System.out.println(update);
    //Mybatis执行更新操作 提交事务（Mybatis默认不提交与jdbc不同）
    sqlSession.commit();
    //释放资源
    sqlSession.close();
  }

  @Test
  public void text2() throws IOException {

    Users users = new Users("xiaojin","qwer1234",20);
    //获得核心配置文件
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //获得session工厂对象
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //获得session会话对象
    SqlSession sqlSession = sessionFactory.openSession();
    //执行操作 参数：namespace+id
    int insert = sqlSession.insert("userMapper.save", users);
    System.out.println(insert);
    //Mybatis执行更新操作 提交事务（Mybatis默认不提交与jdbc不同）
    sqlSession.commit();
    //释放资源
    sqlSession.close();
  }


  @Test
  public void text1() throws IOException {
    //获得核心配置文件
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //获得session工厂对象
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //获得session会话对象
    SqlSession sqlSession = sessionFactory.openSession();
    //执行操作 参数：namespace+id
    List<User> usertList = sqlSession.selectList("userMapper.findAll");
    //打印数据
    System.out.println(usertList);
    //释放资源
    sqlSession.close();
  }

}
