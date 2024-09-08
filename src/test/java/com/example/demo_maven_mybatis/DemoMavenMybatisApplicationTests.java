package com.example.demo_maven_mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class DemoMavenMybatisApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

	@Test
	void testHikariCPConnection() {
		try {
			Connection connection = dataSource.getConnection();
			System.out.print("Connection : ");
			System.out.println(connection);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	void testByBatis() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			System.out.print("sqlSession : ");
			System.out.println(sqlSession);

			Connection connection = sqlSession.getConnection();
			System.out.print("Connection : ");
			System.out.println(connection);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
