package com.hua.People;

/**
 * ���û��൥���������̳��û� �û���¼ʵ��
 * 
 * @author ��shuohua
 *
 */
public class User {
	private int id;
	private String userName;
	private String password;
	private String userDesc;

	public User(String name, String password) {
		this.userName = name;
		this.password = password;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

		// TODO Auto-generated constructor stub
	}

}
