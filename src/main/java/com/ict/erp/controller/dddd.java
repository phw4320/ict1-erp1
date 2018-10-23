package com.ict.erp.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.erp.dao.LevelInfoDAO;
import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class dddd {
	@Autowired
	private LevelInfoDAO ldao;
	
	@Autowired
	private LevelInfoService ls;
	
	@Autowired
	@Qualifier("hikariDataSource")
	private DataSource ds;
	private LevelInfo li = new LevelInfo();
	
	@Test
	public void selectListTest() throws SQLException {
		assertNotNull(ds.getConnection());
		assertEquals(10, ls.getLevelInfoList(li).size());
	}
	@Test
	public void selectInfoTest1() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLinum(81);
		assertNotNull(ls.getLevelInfo(li));
	}	@Test
	public void selectInfoTest2() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLinum(82);
		assertNull(ls.getLevelInfo(li));
	}	
}