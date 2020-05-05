package com.mx.dao;


import com.mx.io.Resources;
import com.mx.mapper.UserMapper;
import com.mx.pojo.User;
import com.mx.sqlSession.SqlSession;
import com.mx.sqlSession.SqlSessionFactory;
import com.mx.sqlSession.SqlSessionFactoryBuilder;
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

        List<User> users = sqlSession.getAll("user.findAll", user);

//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.findAll();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}