package com.nt.util;

import java.io.Serializable;

public class Book implements Serializable {
	private Integer isbn;
	private String name;
	private Float price;

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public Book(Integer isbn, String name) {
		super();
		this.isbn = isbn;
		this.name = name;
	}

	public void setPrice(float f) {
		this.price = f;
	}

	public Book(Integer isbn) {
		super();
		this.isbn = isbn;
	}

	public Book(Integer isbn, String name, Float price) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

}
