package com.study.business;

import java.sql.Connection;
import java.sql.SQLException;

import com.study.dao.UserDAO;
import com.study.jdbc.utils.JdbcUtils;
import com.study.pojo.AdminUser;
import com.study.pojo.User;

public class LoginBiz {
	private User user;
	private AdminUser adminUser;
	private UserDAO userdao = new UserDAO();
	
	public void doBusiness()
	{
	Connection conn = null;
	 try {
		conn = JdbcUtils.getConn();
		userdao.setConn(conn);
		user = userdao.queryUser(user.getUsername(), user.getPassword());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void setBizData(Object obj)
	{
		this.user = (User) obj;
	}
	
	public Object getResult()
	{
		return user;
	}
	
	public void doAdminBusiness()
	{
	Connection conn = null;
	 try {
		conn = JdbcUtils.getConn();
		userdao.setConn(conn);
		adminUser = userdao.queryAdminUser(adminUser.getName(), adminUser.getPassword());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void setAdminBizData(Object obj)
	{
		this.adminUser = (AdminUser) obj;
	}
	
	public Object getAdminResult()
	{
		return adminUser;
	}
}
