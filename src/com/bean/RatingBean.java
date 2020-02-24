package com.bean;
import java.time.*;

public class RatingBean {

	private int id;
	private int byId;
	private int bookId;
	private java.sql.Date dateOfCreation;
	

	private String rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getById() {
		return byId;
	}
	public void setById(int byId) {
		this.byId = byId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
	public java.sql.Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(java.sql.Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}

