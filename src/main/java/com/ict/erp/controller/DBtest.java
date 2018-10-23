package com.ict.erp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
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
		assertEquals(10, ls.getLevelInfoList(null).size());
	}
	@Test
	public void selDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLinum(81);
		assertNotNull(ldao.selectLevelInfo(li));
	}
	@Test
	public void selServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLinum(81);
		assertNotNull(ls.getLevelInfo(li));
	}
	@Test
	public void insertDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLinum(82);
		li.setLilevel(64);
		li.setLiname("97");
		li.setLidesc("hello");
		assertEquals(1, ldao.insertLevelInfo(li));
	}
	@Test
	public void insertServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLilevel(83);
		li.setLinum(65);
		li.setLiname("98");
		li.setLidesc("bye");
		assertEquals(1, ls.insertLevelInfo(li));
	}
	@Test
	public void deleteDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());

		int linum = 29;
		assertEquals(1, ldao.deleteLevelInfo(linum));
	}
	@Test
	public void deleteServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		int linum = 30;
		assertEquals(1, ls.deleteLevelInfo(linum));
	}
	@Test
	public void updateDaoTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLilevel(61);
		li.setLinum(31);
		li.setLiname("111");
		li.setLidesc("hi");
		assertEquals(1, ldao.updateLevelInfo(li));
	}
	@Test
	public void updateServiceTest() throws SQLException {
		assertNotNull(ds.getConnection());
		li.setLilevel(62);
		li.setLinum(32);
		li.setLiname("111");
		li.setLidesc("hi");
		assertEquals(1, ls.updateLevelInfo(li));
	}
}
