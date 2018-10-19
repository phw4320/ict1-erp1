package com.ict.erp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class DBtest {
	@Autowired
	private LevelInfoDAO ldao;
	
	@Autowired
	private LevelInfoService ls;
	
	@Autowired
	@Qualifier("hikariDataSource")
	private DataSource ds;
	private LevelInfo li = new LevelInfo();
	
	@Test
	public void selectDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		assertEquals(10, ldao.selectLevelInfoList(null).size());
	}
	@Test
	public void selectServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		assertEquals(9, ls.getLevelInfoList(null).size());
	}
	@Test
	public void selDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLiname("63");
		assertEquals(1, ls.getLevelInfo(li).size());
	}
	@Test
	public void selServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLiname("63");
		assertEquals(1, ls.getLevelInfo(li).size());
	}
	@Test
	public void insertDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLinum(50);
		li.setLilevel(78);
		li.setLiname("97");
		li.setLidesc("hello");
		assertEquals(1, ls.insertLevelInfo(li));
	}
	@Test
	public void insertServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLilevel(77);
		li.setLinum(51);
		li.setLiname("98");
		li.setLidesc("bye");
		assertEquals(1, ls.insertLevelInfo(li));
	}
	@Test
	public void deleteDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());

		int linum = 50;
		assertEquals(1, ls.deleteLevelInfo(linum));
	}
	@Test
	public void deleteServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		int linum = 51;
		assertEquals(1, ls.deleteLevelInfo(linum));
	}
	@Test
	public void updateDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLilevel(39);
		li.setLinum(27);
		li.setLiname("111");
		li.setLidesc("hi");
		assertEquals(1, ls.updateLevelInfo(li));
	}
	@Test
	public void updateServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLilevel(39);
		li.setLinum(29);
		li.setLiname("111");
		li.setLidesc("hi");
		assertEquals(1, ls.updateLevelInfo(li));
	}
}
