package com.xiongkaijie.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public interface IDBUtil {
	
	/**
	 * 获取数据库连接对象
	 * @return 返回数据库连接对象
	 */
	Connection getConn();
	
	/**
	 * @author Administrator
	 * @createDate 2013-10-18上午12:54:00
	 * @param con 数据库连接对象
	 * @param ps 预编译对象
	 * @param rs 结果集对象
	 */
	void close(Connection con, PreparedStatement ps, ResultSet rs);
	/**
	 * =_=zly
	 * @author Administrator
	 * @createDate 2013-11-18下午4:54:10
	 * @param con 数据库连接对象
	 * @param cs 存储过程或函数呼叫对象
	 * @param rs 数据库结果集对象
	 */
	void close(Connection con, CallableStatement cs, ResultSet rs);
}
