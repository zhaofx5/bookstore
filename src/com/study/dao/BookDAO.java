package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.pojo.Book;

public class BookDAO {
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public List<Book> queryAllBooks() throws SQLException
	{
		String sql = "select * from tb_book";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		while(rs.next())
		{
			long bookid = rs.getLong("bookid");
			String title = rs.getString("title");
			String pic = rs.getString("pic");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			book = new Book(bookid,title,pic,author,price);
			books.add(book);
		}
		return books;
	}
	
	
	public Book getBookById(long bookid) throws SQLException
	{
		String sql = "select * from tb_book where bookid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, bookid);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			long id = rs.getLong("bookid");
			String title = rs.getString("title");
			String pic = rs.getString("pic");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			Book book = new Book(id,title,pic,author,price);
			return book;
		}
		
		return null;
		
	}
	
}
