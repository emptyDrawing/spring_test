package com.bit.myapp03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.bit.myapp03.model.entity.GuestVo;

public class GuestDaoImf01 implements GuestDao {

	Logger log = Logger.getLogger(getClass());
	
	DataSource dataSource;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	public GuestDaoImf01() {
		log.info("guestDaoImf01 생성");
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM GUEST ORDER BY SABUN";
		List<GuestVo> list = new ArrayList<GuestVo>();
		try(Connection conn=dataSource.getConnection()){
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVo bean = new GuestVo(
						rs.getInt("sabun")		,rs.getString("name")		,rs.getDate("nalja")
						,rs.getInt("pay")
						);
				list.add(bean);
				log.debug(bean);
			}
		}
		
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

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
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
