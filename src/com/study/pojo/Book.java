package com.study.pojo;

public class Book {
	//  ÈºÆid
	private long bookid;
	private String title;
	private String pic;
	private String author;
	private double price;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(long bookid, String title, String pic, String author,
			double price) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.pic = pic;
		this.author = author;
		this.price = price;
	}

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{\"bookid\":\"" + this.bookid + "\",\"title\":\"" + this.title
				+ "\",\"pic\":\"" + this.pic + "\",\"author\":\"" + this.author
				+ "\",\"price\":\"" + this.price + "\"}";
	}

}
