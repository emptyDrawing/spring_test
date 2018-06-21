package com.bit.spring06.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.spring06.model.entity.GuestVo;

public class GuestDao03Imf implements GuestDao {

	private JdbcTemplate template = new JdbcTemplate();

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	Logger log = Logger.getLogger(getClass()); 
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		return template.query(sql, new RowMapper<GuestVo>(){

			@Override
			public GuestVo mapRow(ResultSet rs, int cnt) throws SQLException {
				log.debug("RowMapper Cnt :"+cnt);
				return new GuestVo(
							rs.getInt("sabun")	,rs.getString("name") ,rs.getDate("nalja")
							,rs.getInt("pay")
						);
			}// mapRow end
		});
	}// selectAll() -> List<GuestVo> end;

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		String sql ="SELECT * FROM GUEST WHERE SABUN =?";
		Object[] params = new Object[]{pk};
		return template.queryForObject(sql,params,new RowMapper<GuestVo>(){

			@Override
			public GuestVo mapRow(ResultSet rs, int cnt) throws SQLException {
				log.debug("RowMapper Cnt :"+cnt);
				return new GuestVo(
							rs.getInt("sabun")	,rs.getString("name") ,rs.getDate("nalja")
							,rs.getInt("pay")
						);
			}// mapRow end
		});
	}// selectOne() -> GuestVo  end

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
