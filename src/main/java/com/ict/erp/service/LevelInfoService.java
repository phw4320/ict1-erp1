package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.LevelInfo;

public interface LevelInfoService {
	public List<LevelInfo> getLevelInfoList(LevelInfo li) throws SQLException;
	public List<LevelInfo> getLevelInfo(LevelInfo li) throws SQLException;
	public int insertLevelInfo(LevelInfo li) throws SQLException;
	public int updateLevelInfo(LevelInfo li) throws SQLException;
	public int deleteLevelInfo(int linum) throws SQLException;
	public int updateLevelInfoError(LevelInfo li) throws SQLException;
	
}
