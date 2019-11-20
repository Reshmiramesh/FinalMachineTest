package com.ust.beans;

//Login class
public class Login {
	
	//Instance variables
	private int userId;
	private String username;
	private String password;
	
	
	//Default constructor
	public Login() 
	{
		super();
	}

	//Parameterized constructor with userId
	public Login(int userId, String username, String password) 
	{
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	
	//Parameterized constructor with username and password
	public Login(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	
	//Getter for userId
	public int getUserId() {
		return userId;
	}

	//setter for userId
	public void setUserId(int userId) {
		this.userId = userId;
	}

	//getter for username
	public String getUsername() {
		return username;
	}

	//setter for username
	public void setUsername(String username) {
		this.username = username;
	}

	//getter for password
	public String getPassword() {
		return password;
	}

	//setter for password
	public void setPassword(String password) {
		this.password = password;
	}

	//toString method
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username
				+ ", password=" + password + "]";
	}

}
