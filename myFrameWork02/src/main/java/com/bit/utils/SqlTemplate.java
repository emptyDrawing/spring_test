package com.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlTemplate<T> {

	
	private PreparedStatement pstmt;
	private Connection conn;
	private ResultSet rs;
	
	public SqlTemplate() {
		try {
			getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	void getConnection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
	}

	public T queryOne(String sql,RowMapper<T> mapper, Object[] objs) throws SQLException{
		return  queryList(sql, mapper,objs).get(0);
	}

	public List<T>  queryList(String sql, RowMapper<T> mapper) throws SQLException{
		return  queryList(sql, mapper,new Object[]{});
	}
	
	public List<T>  queryList(String sql, RowMapper<T> mapper, Object[] objs) throws SQLException{
		List<T> list = new ArrayList<T>();
		try{
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(mapper.mapRow(rs));
			}
		}finally{
			close();
		}
		return list ;
	}


	public int queryUpdate(String sql, Object[] objs) throws SQLException{
		try{
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		}finally{
			close();
		}
	}

	private void close() throws SQLException {
		if(conn!=null)conn.close();

	}
	
}
