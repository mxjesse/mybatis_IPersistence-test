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
    public void getQueryMapper() throws PropertyVetoException, DocumentException {

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
    public void getAddMapper() {

    }
}