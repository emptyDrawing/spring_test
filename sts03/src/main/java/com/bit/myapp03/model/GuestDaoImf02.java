package com.bit.myapp03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.bit.myapp03.model.entity.GuestVo;


public class GuestDaoImf02 implements GuestDao {

	Logger log = Logger.getLogger(getClass());
	
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplatel(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplatel() {
		return jdbcTemplate;
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM GUEST ORDER BY SABUN DESC";
		return jdbcTemplate.query(sql, new RowMapper<GuestVo>() {
			@Override
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean = new GuestVo(rs.getInt("sabun"),rs.getString("name"),rs.getDate("nalja"),rs.getInt("pay")							);
				log.debug("rowNum["+rowNum+"]->"+bean);
				return bean ;
			}// mapRow end
		});// annoy...
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM GUEST WHERE SABUN = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {sabun}, new RowMapper<GuestVo>() {
			@Override
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean = new GuestVo(rs.getInt("sabun"),rs.getString("name"),rs.getDate("nalja"),rs.getInt("pay")							);
				log.debug("selectOne->"+bean);
				return bean ;
			}// mapRow end
		});// annoy...
	}

	@Override
	public int insertOne(final GuestVo bean) throws SQLException {
		final String sql = "INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getSabun());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getPay());
				return pstmt;
			}// createPreparedStatement
		});// return..
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
