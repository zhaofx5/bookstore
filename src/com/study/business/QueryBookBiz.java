package com.study.business;

import java.sql.Connection;
import java.sql.SQLException;

import com.study.dao.BookDAO;
import com.study.jdbc.utils.JdbcUtils;
import com.study.pojo.Book;

public class QueryBookBiz {
	private long bookid;
	private Book book;
	private BookDAO bookdao = new BookDAO();
//	public QueryBookBiz(){
//		System.out.print("ÄãºÃ");
//	}
	
	public void doBusiness()
	{
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			bookdao.setConn(conn);
			book = bookdao.getBookById(bookid);
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
	
	public void setBizData(Object obj)
	{
		this.bookid = (Long) obj;
	}
	
	public Object getResult()
	{
		return book;
	}
}
