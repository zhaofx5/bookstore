package com.study.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDdbc {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.140.22:1521:orcl", "zhao", "pass");
		conn.setAutoCommit(false);
		return conn;
	}

}
