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
	//��ѯ�����鼮�ķ���
	public String query(){
	QueryAllBooks querybooks = new QueryAllBooks();
	querybooks.doBusiness();
	books = (List<Book>) querybooks.getResult();
	return "SUCCESS";
	}
	
	
	
}
