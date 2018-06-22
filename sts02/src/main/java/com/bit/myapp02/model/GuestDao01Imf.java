package com.bit.myapp02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import com.bit.myapp02.model.entity.GuestVo;

public class GuestDao01Imf implements GuestDao<GuestVo> {

	DataSource ds;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestDao01Imf() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("scott");
		bds.setPassword("tiger");
		ds = bds;
	}
	
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM GUEST ORDER BY SABUN";
		return executeQuery(sql, new Object[] {});
	}

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		String sql = "SELECT * FROM GUEST WHERE SABUN = ?";
		return executeQuery(sql,new Object[]{ pk}).get(0);
	}
	
	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		String sql = "INSERT INTO GUEST (SABUN,NAME,PAY,NALJA) VALUES (?,?,?,SYSDATE)";
		return executeUpdate(sql, new Object[] {bean.getSabun(),bean.getName(),bean.getPay()});
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		String sql="UPDATE GUEST SET NAME=?, PAY = ? WHERE SABUN = ?";
		return executeUpdate(sql, new Object[] {bean.getName(),bean.getPay(),bean.getSabun()});
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql="DELETE FROM GUEST WHERE SABUN=?";
		return executeUpdate(sql, new Object[] {pk});
	}

	private List<GuestVo> executeQuery(String sql, Object[] objs) throws SQLException {
		List<GuestVo> list = new ArrayList<GuestVo>();
		try(Connection conn = ds.getConnection()){
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						));
			}
		}
		return list;
	}
	
	private int executeUpdate(String sql, Object[] objs) throws SQLException {
		try(Connection conn = ds.getConnection()){
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<objs.length;i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		}
	}// executeUpdate() -> int end
	

}
