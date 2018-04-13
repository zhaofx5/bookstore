package com.study.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.study.dao.BookDAO;
import com.study.jdbc.utils.JdbcUtils;
import com.study.pojo.Book;

public class QueryAllBooks {
	
	private BookDAO bookdao = new BookDAO();
	private List<Book> books;
	
	public void doBusiness()
	{
		Connection conn = null;
		 try {
			conn = JdbcUtils.getConn();
			bookdao.setConn(conn);
			books = bookdao.queryAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public Object getResult()
	{
		return books;
	}
	
}
