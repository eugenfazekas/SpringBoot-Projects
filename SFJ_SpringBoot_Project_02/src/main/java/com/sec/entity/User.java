package com.sec.entity;

public class User {

	private String fullName;
	private String password;
	
	public User() {

	}


	public User(String fullName, String password) {
	
		this.fullName = fullName;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
