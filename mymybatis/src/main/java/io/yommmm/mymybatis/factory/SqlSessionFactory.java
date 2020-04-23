package io.yommmm.mymybatis.factory;

import io.yommmm.mymybatis.sqlsession.SqlSession;

public interface SqlSessionFactory {

    SqlSession openSession();
}
