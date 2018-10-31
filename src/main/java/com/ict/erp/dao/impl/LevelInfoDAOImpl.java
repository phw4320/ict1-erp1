package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.erp.dao.LevelInfoDAO;
import com.ict.erp.vo.LevelInfo;

@Repository
public class LevelInfoDAOImpl implements LevelInfoDAO{


	@Autowired
	private SqlSession ss;
	
	@Override
	public List<LevelInfo> selectLevelInfoList(LevelInfo li) throws SQLException {
		return ss.selectList("SQL.LEVELINFO.selectLevelInfo",li);
	}
	
	public LevelInfo selectLevelInfo(LevelInfo li) throws SQLException {
		/*List<LevelInfo> liList;
		liList = ss.selectList("SQL.LEVELINFO.getLevelInfo",li);
		System.out.println(liList);
		if (!liList.isEmpty()) {
			return liList;
		} else {
			return null;
		}*/
		return ss.selectOne("SQL.LEVELINFO.getLevelInfo",li);
	}
	
	public int insertLevelInfo(LevelInfo li) throws SQLException {
		return ss.insert("SQL.LEVELINFO.insertLevelInfo",li);
	}

	@Override
	public int updateLevelInfo(LevelInfo li) throws SQLException {
		return ss.insert("SQL.LEVELINFO.updateLevelInfo",li);
	}

	@Override
	public int deleteLevelInfo(int linum) throws SQLException {
		return ss.insert("SQL.LEVELINFO.deleteLevelInfo",linum);
	}
	

	@Override
	public int updateLevelInfoError(LevelInfo li) throws SQLException {
		return ss.insert("SQL.LEVELINFO.updateLevelInfo",li);
	}

	@Override
	public int selectGetLinum() throws SQLException {
		return ss.selectOne("SQL.LEVELINFO.getLinum");
	}

}

