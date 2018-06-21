package com.bit.spring06.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.spring06.model.entity.GuestVo;

public class GuestDao01Imf implements GuestDao {

	private DataSource dateSource;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setDateSource(DataSource dateSource) {
		this.dateSource = dateSource;
	}
	
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql ="SELECT * FROM GUEST ORDER BY SABUN";
		List<GuestVo> list = new ArrayList<GuestVo>();
		try(Connection conn = dateSource.getConnection()){
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
							rs.getInt("sabun")
							,rs.getString("name")
							,rs.getDate("nalja")
							,rs.getInt("pay")
						));
			}// while end
		}//try-resource end
		return list;
	}// selectAll() -> List<GuestVo> end
	
	
	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		
		return null;
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		
		return 0;
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		
		return 0;
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		
		return 0;
	}

}
