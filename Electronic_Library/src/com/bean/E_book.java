package com.bean;

public class E_book {

	int callNo, quantity;
	String name, author, publisher;
	int issued;

	public E_book(int callNo, int quantity, String name, String author, String publisher, int issued) {
		super();
		this.callNo = callNo;
		this.quantity = quantity;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.issued = issued;
	}

	public E_book() {
		// TODO Auto-generated constructor stub
	}

	public E_book(int callNo, String name, String author, String publisher, int quantity) {
		super();
		this.callNo = callNo;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int getCallNo() {
		return callNo;
	}

	public void setCallNo(int callNo) {
		this.callNo = callNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIssued() {
		return issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}

}
