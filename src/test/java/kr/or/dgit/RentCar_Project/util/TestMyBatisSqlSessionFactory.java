package kr.or.dgit.RentCar_Project.util;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMyBatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory = null;
	}

	@Test
	public void test1SqlSessionFactory() {
		SqlSessionFactory factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
		Assert.assertNotNull(factory);
	}
	
	@Test
	public void test2OpenSession() {
		Connection con = factory.openSession().getConnection();
		Assert.assertNotNull(con);
	}

}
