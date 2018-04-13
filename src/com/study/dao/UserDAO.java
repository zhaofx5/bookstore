package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.study.pojo.AdminUser;
import com.study.pojo.User;

public class UserDAO {
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void saveUser(User user) throws SQLException
	{
		String sql = "insert into tb_user(username,password,filename) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFilename());
		ps.execute();
	}
	
	public User queryUser(String username ,String password) throws SQLException
	{
		String sql ="select * from tb_user where username = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			User user = new User(username,password,rs.getString("filename"),rs.getInt("state"));
			return user;
		}
		
		return null;
		
	}
	
	//查询图书管理员用户的代码
	public AdminUser queryAdminUser(String username ,String password) throws SQLException
	{
		String sql ="select * from tb_admin_user where name = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			AdminUser adminUser = new AdminUser(username,password);
			return adminUser;
		}
		return null;
	}
}
