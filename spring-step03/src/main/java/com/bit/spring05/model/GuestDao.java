package com.bit.spring05.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.spring05.model.entity.GuestVo;

public interface GuestDao {

	void insertOne(GuestVo command) throws SQLException;

	GuestVo selectOne(int idx) throws SQLException;

	int deleteOne(int parseInt) throws SQLException;

	int updatOne(GuestVo command) throws SQLException;

	List<GuestVo> selectAll() throws SQLException;
	
}
