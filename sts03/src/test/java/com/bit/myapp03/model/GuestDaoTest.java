package com.bit.myapp03.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bit.myapp03.model.GuestDao;
import com.bit.myapp03.model.GuestDaoImf01;

public class GuestDaoTest {

	static GuestDao guestDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource );
		guestDao = (GuestDao) factory.getBean("guestDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		assertNotNull("dao 주입실패..",guestDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConnection() {
		assertNotNull("접속..",((GuestDaoImf01)guestDao).getDataSource());
	}
	
	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(guestDao.selectAll());
		assertTrue(guestDao.selectAll().size()>0);
	}

}
