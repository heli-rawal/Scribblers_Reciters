package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BookBean;
import com.util.DatabaseConnection;

public class BookDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(BookBean book){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		//ID INT(10) PRIMARY KEY AUTO_INCREMENT,URL VARCHAR(100),TITLE VARCHAR(100) NOT NULL,DESCRIPTION VARCHAR(255) NOT NULL,PUBLISHER_ID INT(10) 
		//,ISBN VARCHAR(100) UNIQUE,CATEGORY_ID INT(10) REFERENCES CATEGORY,DATE_OF_PUBLICATION DATE,PRICE FLOAT(10) NOT NULL);
		if(conn!=null){
			String insertSQL = "INSERT INTO Book(TITLE,DESCRIPTION,ISBN,PRICE)values(?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				/*private int id;
 
 private String title;
 private String description;
 
 private String isbn;
 private float price;
p*/
			
				
				pstmt.setString(1,book.getTitle());
				pstmt.setString(2,book.getDescription());
				
				pstmt.setString(3,book.getIsbn());
				
				pstmt.setFloat(4,book.getPrice());
			
				
				
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected>0){
					result = true;
					System.out.println("INsert Successful...........");
					
				}else{
					System.out.println("INsert Failed...........");
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result; 
	}

	public List<BookBean> select() {
		List<BookBean> bookList = new ArrayList<BookBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Book";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				BookBean book= null;
				while(rs.next()){
					 book= new BookBean();
					
					book.setId(rs.getInt("id"));
					book.setDescription(rs.getString("description"));
					book.setIsbn(rs.getString("isbn"));
					
					book.setPrice(rs.getFloat("price"));
					book.setTitle(rs.getString("title"));
					
					
					bookList.add(book);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return bookList;
	}

	public BookBean getBookByPK(int id) {
		BookBean book= new BookBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM book WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					book.setId(rs.getInt("id"));
					book.setDescription(rs.getString("description"));
					book.setIsbn(rs.getString("isbn"));
					book.setPrice(rs.getFloat("price"));
					
					book.setTitle(rs.getString("title"));
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return book;
	}

	public boolean update(BookBean book) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE BOOK SET title=?,description=?,isbn=?,price=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				
				pstmt.setString(1,book.getTitle());
				pstmt.setString(2,book.getDescription());
				
				pstmt.setString(3,book.getIsbn());
				
				pstmt.setFloat(4,book.getPrice());
				pstmt.setInt(5,book.getId());
				
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected>0){
					result = true;
					System.out.println("Update Successful...........");
					
				}else{
					System.out.println("Update Failed...........");
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String deleteSQL = "DELETE FROM BOOK WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, id);
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected>0){
					result = true;
					System.out.println("Delete Successful...........");
					
				}else{
					System.out.println("Delete Failed...........");
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	
}

















