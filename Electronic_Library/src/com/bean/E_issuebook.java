package com.bean;

import java.sql.Date;

public class E_issuebook {

	int callNo, id;
	String name, mobileNo, returnstatus;
	Date date;

	public E_issuebook() {
		super();
		this.callNo = callNo;
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.returnstatus = returnstatus;
		this.date = date;
	}

	public E_issuebook(int callNo, int id, String name, String mobileNo) {
		super();
		this.callNo = callNo;
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
	}

	public int getCallNo() {
		return callNo;
	}

	public void setCallNo(int callNo) {
		this.callNo = callNo;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
