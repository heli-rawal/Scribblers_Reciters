package com.bean;

public class ImageBean {
//IMAGE AND AUTHOR DESCRIPTION USING FILE UPLOAD LOGICS
		private int id;
		private int bookId;
		private String url;
		private boolean isFront;
		private boolean isBack;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public boolean isFront() {
			return isFront;
		}
		public void setFront(boolean isFront) {
			this.isFront = isFront;
		}
		public boolean isBack() {
			return isBack;
		}
		public void setBack(boolean isBack) {
			this.isBack = isBack;
		}
		
}
