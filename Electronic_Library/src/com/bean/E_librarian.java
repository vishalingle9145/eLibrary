package com.bean;

public class E_librarian {

	int id;
	String name, email, password, mobileNo;

	public E_librarian(int id, String name, String email, String password, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public E_librarian(String name, String email, String password, String mobileNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public E_librarian() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
