package io.yommmm.mymybatis;

import io.yommmm.mymybatis.entity.User;
import io.yommmm.mymybatis.factory.DefaultSqlSessionFactory;
import io.yommmm.mymybatis.factory.SqlSessionFactory;
import io.yommmm.mymybatis.mapper.UserMapper;
import io.yommmm.mymybatis.sqlsession.SqlSession;

public class TestDemo {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByPrimaryKey("1");

        System.out.println(user.toString());
    }
}
