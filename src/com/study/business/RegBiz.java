package com.study.business;

import java.sql.Connection;
import java.sql.SQLException;

import com.study.dao.UserDAO;
import com.study.jdbc.utils.JdbcUtils;
import com.study.pojo.User;

public class RegBiz {
	private User user;
	private UserDAO userdao = new UserDAO();
	private String resultCode;
	
	public void doBusiness()
	{
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			userdao.setConn(conn);
			userdao.saveUser(user);
			conn.commit();
			resultCode = "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultCode=e.getMessage();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getResult()
	{
		return resultCode;
	}
	
	public void setBizData(Object obj)
	{
		this.user = (User) obj;
	}
	
}
