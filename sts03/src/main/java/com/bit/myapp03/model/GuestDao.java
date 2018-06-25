package com.bit.myapp03.model;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.bit.myapp03.model.entity.GuestVo;

public interface GuestDao {

	public List<GuestVo> selectAll() throws SQLException;
	public GuestVo selectOne(int sabun) throws SQLException;
	public int insertOne(GuestVo bean) throws SQLException;
	public int updateOne(GuestVo bean) throws SQLException;
	public int deleteOne(int sabun) throws SQLException;
	
}
