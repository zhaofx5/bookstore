package com.study.pojo;

public class User {
	private String username;
	private String password;
	private String filename;
	private int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password,String filename) {
		super();
		this.username = username;
		this.password = password;
		this.filename = filename;
	}
	public User(String username, String password,String filename,int state) {
		super();
		this.username = username;
		this.password = password;
		this.filename = filename;
		this.state = state;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
