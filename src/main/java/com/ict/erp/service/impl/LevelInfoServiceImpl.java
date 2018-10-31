package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.erp.dao.LevelInfoDAO;
import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@Service
public class LevelInfoServiceImpl implements LevelInfoService {

	@Autowired
	private LevelInfoDAO lidao;

	@Override
	public List<LevelInfo> getLevelInfoList(LevelInfo li) throws SQLException {
		return lidao.selectLevelInfoList(li);
	}
	
	public LevelInfo getLevelInfo(LevelInfo li) throws SQLException {
		return lidao.selectLevelInfo(li);
	}

	@Override
	public int insertLevelInfo(LevelInfo li) throws SQLException {
		return lidao.insertLevelInfo(li);
	}

	@Override
	public int updateLevelInfo(LevelInfo li) throws SQLException {
		return lidao.updateLevelInfo(li);
	}

	@Override
	public int deleteLevelInfo(int linum) throws SQLException {
		return lidao.deleteLevelInfo(linum);
	}
	
	@Override
	public int updateLevelInfoError(LevelInfo li) throws SQLException {
		return lidao.updateLevelInfo(li);
	}

	@Override
	public int getLinum() throws SQLException {
		return lidao.selectGetLinum();
	}
}
