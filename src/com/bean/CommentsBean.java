package com.bean;

import java.util.*;

public class CommentsBean {
	//(ID INT(10) PRIMARY KEY AUTO_INCREMENT,DESCRIPTION VARCHAR(255),BY_ID INT(10) REFERENCES USER,TO_ID INT(10) REFERENCES AUTHOR,IS_DELETED boolean default false,DATE_OF_CREATION DATE NOT NULL);
	private int id;
	private String description;
	private int byId;
	private int toId;
	
	private java.sql.Date dateOfCreation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getById() {
		return byId;
	}

	public void setById(int byId) {
		this.byId = byId;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public java.sql.Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(java.sql.Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
			
}


