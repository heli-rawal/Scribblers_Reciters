package com.bean;

public class MessagesBean {
//CREATE TABLE MESSAGES(ID INT(10) ,BY_ID INT(10) ,DESCRIPTION ,FOR_ID,date_of_creation);
		private int id;
		private int byId;
		private String description;
		private int toId;
		private java.sql.Date dateOfCreation;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
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
