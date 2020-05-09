package com.mx.dao;


import com.mx.io.Resources;
import com.mx.mapper.UserMapper;
import com.mx.pojo.User;
import com.mx.sqlSession.SqlSession;
import com.mx.sqlSession.SqlSessionFactory;
import com.mx.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoTest {

    @Before
    public void doBefore() throws PropertyVetoException {

    }

    @Test
    public void findAll() throws Exception {

        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("mx");

        List<User> users = sqlSession.selectList("com.mx.mapper.UserMapper.findAll", user);

//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.findAll();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    @Test
    public void selectOne() throws Exception {

        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("xiaoming");

        User u = sqlSession.selectOne("com.mx.mapper.UserMapper.findAll", user);
        System.out.println(u);
    }

    @Test
    public void queryMapper() throws PropertyVetoException, DocumentException {

        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryOneMapper() throws PropertyVetoException, DocumentException {

        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("lucy");

        User one = userMapper.findByCondition(user);
        System.out.println(one);
    }

    @Test
    public void addMapper() throws PropertyVetoException, DocumentException {

        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = new ArrayList<>();

        User user1 = new User();
        User user2 = new User();

        user1.setUsername("jack");
        user1.setPassword("jack123456");
        user1.setBirthday("20200101");

        user2.setUsername("lucy");
        user2.setPassword("lucy123");
        user2.setBirthday("20000101");

        users.add(user1);
        users.add(user2);

        userMapper.add(users);
    }

    @Test
    public void updateMapper() throws PropertyVetoException, DocumentException {

        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setUsername("jack");

        user.setPassword("111111111");
        user.setBirthday("20200101");

        userMapper.update(user);
    }

    @Test
    public void deleteMapper() throws PropertyVetoException, DocumentException {
        InputStream inputStream = Resources.getSourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setUsername("jack");

        userMapper.delete(user);
    }
}