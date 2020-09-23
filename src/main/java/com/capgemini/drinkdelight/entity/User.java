package com.capgemini.drinkdelight.entity;

public class User {
	private String name;
	private String email;
	private String userId;
	private String number;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String email, String userId, String number) {
		super();
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
