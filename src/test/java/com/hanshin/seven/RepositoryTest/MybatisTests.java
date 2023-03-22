package com.hanshin.seven.RepositoryTest;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisTests {

	  @Autowired
	  private SqlSessionFactory sessionFactory;
	
	  @Test
	  public void testMyBatisConnection() throws Exception {
	    try (SqlSession sqlSession = sessionFactory.openSession()) {
	      Connection connection = sqlSession.getConnection();
	      Assert.assertNotNull(connection);
	      Assert.assertFalse(connection.isClosed());
	    }
	  }
}
