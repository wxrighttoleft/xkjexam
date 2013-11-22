package com.xiongkaijie.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDBUtil implements IDBUtil {

	public Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ZLY", "XKJ", "123456");
		} catch (ClassNotFoundException e) {
			throw new SysException(e);
		} catch (SQLException e) {
			throw new SysException(e);
		}
		return conn;
	}

	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(Connection con, CallableStatement cs, ResultSet rs) {
		// TODO Auto-generated method stub
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		if(cs != null){
			try {
				cs.close();
			} catch (SQLException e) {
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

}
