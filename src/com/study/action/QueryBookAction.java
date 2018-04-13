package com.study.action;

import com.study.business.QueryBookBiz;
import com.study.pojo.Book;

public class QueryBookAction {
	private String bookid;
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String execute(){
		QueryBookBiz querybook = new QueryBookBiz();
		querybook.setBizData(Long.parseLong(bookid));
		querybook.doBusiness();
		book =(Book) querybook.getResult();
		return "SUCCESS";
	}

}
