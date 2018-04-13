package com.study.action;

import java.util.List;

import com.study.business.QueryAllBooks;
import com.study.pojo.Book;

public class QueryAllBooksAction {
	private List<Book> books;
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	//查询所有书籍的方法
	public String query(){
	QueryAllBooks querybooks = new QueryAllBooks();
	querybooks.doBusiness();
	books = (List<Book>) querybooks.getResult();
	return "SUCCESS";
	}
	
	
	
}
