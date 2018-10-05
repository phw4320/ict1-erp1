package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.LevelInfo;

public interface LevelInfoDAO {
	public List<LevelInfo> selectLevelInfoList(LevelInfo li) throws SQLException;
	public List<LevelInfo> selectLevelInfo(LevelInfo li) throws SQLException;
	public int insertLevelInfo(LevelInfo li) throws SQLException;
	public int updateLevelInfo(LevelInfo li) throws SQLException;
	public int deleteLevelInfo(int linum) throws SQLException;
}
