package com.bit.spring05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.spring05.model.entity.GuestVo;

public class GuestDao2Imf implements GuestDao {

	JdbcTemplate template = new JdbcTemplate();
	
	
	RowMapper rowM = new RowMapper(){
		@Override
		public Object mapRow(ResultSet rs, int cnt) throws SQLException {
			GuestVo bean = new GuestVo(
						rs.getInt("sabun")		,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
					);
			return bean;
		};
	};
	
	public GuestDao2Imf(DataSource dataSource) {
		template.setDataSource(dataSource);
	}
	
	@Override
	public void insertOne(GuestVo command) throws SQLException {
		String sql ="INSERT INTO GUEST (NAME,PAY,NALJA) VALUES(?,?,NOW())";	
		template.update(sql, command.getName(), command.getPay());
	}

	@Override
	public GuestVo selectOne(int idx) throws SQLException {
		String sql = "SELECT * FROM GUEST WHERE SABUN=?";
		return (GuestVo) template.queryForObject(sql, new Object[]{idx}, rowM);
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql = "DELETE FROM GUEST WHERE SABUN=?";
		return template.update(sql, new Object[]{pk});
	}

	@Override
	public int updatOne(GuestVo command) throws SQLException {
		String sql = "UPDATE GUEST SET NAME=?, PAY=? WHERE SABUN=?";
		return template.update(sql, new Object[]{command.getName(), command.getPay(), command.getSabun()});
	}

	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql ="SELECT * FROM GUEST ORDER BY SABUN";
		return (List<GuestVo>) template.query(sql,rowM);
	}

}
