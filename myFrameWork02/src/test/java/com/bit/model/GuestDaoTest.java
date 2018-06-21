package com.bit.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bit.model.entity.GuestVo;

public class GuestDaoTest {

	GuestDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new GuestDao();
	}

	@Test
	public void test() throws SQLException {
		List<GuestVo> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
	}

}
