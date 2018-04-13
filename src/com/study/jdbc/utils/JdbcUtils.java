package com.study.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException
	{
		String url="jdbc:mysql://115.28.137.186:3306/bookstore";
		String user ="bookstore";
		String password = "DAxiao917";
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		return conn;
	}
	
}
