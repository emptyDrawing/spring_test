package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.model.entity.GuestVo;
import com.bit.utils.RowMapper;
import com.bit.utils.SqlTemplate;

public class GuestDao {

	Logger log = Logger.getLogger(this.getClass());

	RowMapper mapper =  new RowMapper<GuestVo>() {
			public GuestVo mapRow(ResultSet rs) throws SQLException {
				GuestVo bean = new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						);
				return bean;
			}
		};
	
	
	
	public GuestDao() {	}

	public List<GuestVo>selectAll() throws SQLException{
		log.debug("selectAll() start");
		String sql = "SELECT * FROM GUEST";
		SqlTemplate<GuestVo> template = new SqlTemplate<GuestVo>();
		return template.queryList(sql,mapper);
	}


	public GuestVo selectOne(int pk) throws SQLException{
		log.debug("selectOne :"+pk);
		String sql = "select * from guest where sabun=?";
		SqlTemplate<GuestVo> template = new SqlTemplate<GuestVo>();
	
		return template.queryOne(sql,mapper,new Object[]{pk});
	}
	
	public void insertOne(GuestVo bean) throws SQLException{
		log.debug("insertOne() :"+bean);
		String sql = "INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		SqlTemplate<GuestVo> template = new SqlTemplate<GuestVo>();
		template.queryUpdate(sql, new Object[]{bean.getSabun(),bean.getName(),bean.getPay()});
	}
	
	public int updateOne(GuestVo bean) throws SQLException{
		int result = 0;
		String sql = "UPDATE GUEST SET NAME = ?, PAY=? WHERE SABUN = ?";
		SqlTemplate<GuestVo> template = new SqlTemplate<GuestVo>();
		result = template.queryUpdate(sql, new Object[]{bean.getName(),bean.getPay(),bean.getSabun()});
		return result;
	}

	
	public int deleteOne(int pk) throws SQLException{
		int result = 0;
		String sql ="DELETE FROM GUEST WHERE SABUN = ?";
		Object[] objs = new Object[]{pk};
		SqlTemplate<GuestVo> template = new SqlTemplate<GuestVo>();

		result = template.queryUpdate(sql, objs);
		return result;
	}

}
