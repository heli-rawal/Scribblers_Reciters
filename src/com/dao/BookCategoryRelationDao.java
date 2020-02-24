package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BookCategoryRelationBean;
import com.util.DatabaseConnection;

public class BookCategoryRelationDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(BookCategoryRelationBean bookCategoryRelation){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO Book_Category_Relation(Book_id,Category_id)values(?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				pstmt.setInt(1,bookCategoryRelation.getBookId());
				pstmt.setInt(2,bookCategoryRelation.getCategoryId());
				
				
				
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

	public List<BookCategoryRelationBean> select() {
		List<BookCategoryRelationBean> bookCategoryRelationList = new ArrayList<BookCategoryRelationBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Book_category_Relation";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				BookCategoryRelationBean bookCategoryRelation = null;
				while(rs.next()){
					bookCategoryRelation= new BookCategoryRelationBean();
					
					bookCategoryRelation.setId(rs.getInt("id"));
					
					bookCategoryRelation.setBookId(rs.getInt("book_id"));
					bookCategoryRelation.setId(rs.getInt("category_id"));
					
					
					
					bookCategoryRelationList.add(bookCategoryRelation);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return bookCategoryRelationList;
	}

	public BookCategoryRelationBean getBookCategoryRelationByPK(int id) {
		BookCategoryRelationBean bookCategoryRelation= new BookCategoryRelationBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM BOOK_CATEGORY_RELATION WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					bookCategoryRelation.setId(rs.getInt("id"));
					bookCategoryRelation.setBookId(rs.getInt("book_id"));
					bookCategoryRelation.setCategoryId(rs.getInt("category_id"));
					
						}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return bookCategoryRelation;
	}

	public boolean update(BookCategoryRelationBean bookCategoryRelation) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE BOOK_CATEGORY_RELATION SET BOOK_ID=?,CATEGORY_ID=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setInt(1,bookCategoryRelation.getBookId());
				pstmt.setInt(2,bookCategoryRelation.getCategoryId());
				
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
			String deleteSQL = "DELETE FROM BOOK_CATEGORY_RELATION WHERE ID=?";
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

















