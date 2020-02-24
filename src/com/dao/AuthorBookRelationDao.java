package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.AuthorBookRelationBean;
import com.util.DatabaseConnection;

public class AuthorBookRelationDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(AuthorBookRelationBean authorBookRelation){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO Author_Book_Relation(author_id,Book_id)values(?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				pstmt.setInt(1,authorBookRelation.getAuthorId());
				pstmt.setInt(2,authorBookRelation.getBookId());
				
				
				
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

	public List<AuthorBookRelationBean> select() {
		List<AuthorBookRelationBean> authorBookRelationList = new ArrayList<AuthorBookRelationBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Author_Book_Relation";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				AuthorBookRelationBean authorBookRelation = null;
				while(rs.next()){
					authorBookRelation= new AuthorBookRelationBean();
					
					authorBookRelation.setId(rs.getInt("id"));
					authorBookRelation.setAuthorId(rs.getInt("author_id"));
					authorBookRelation.setBookId(rs.getInt("book_id"));
					
					
					
					authorBookRelationList.add(authorBookRelation);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return authorBookRelationList;
	}

	public AuthorBookRelationBean getAuthorBookRelationByPK(int id) {
		AuthorBookRelationBean authorBookRelation= new AuthorBookRelationBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM AUTHOR_BOOK_RELATION WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					authorBookRelation.setId(rs.getInt("id"));
					authorBookRelation.setAuthorId(rs.getInt("author_id"));
					authorBookRelation.setBookId(rs.getInt("book_id"));
					
						}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return authorBookRelation;
	}

	public boolean update(AuthorBookRelationBean authorBookRelation) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE AUTHOR_BOOK_RELATION SET AUTHOR_ID=?,BOOK_ID=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setInt(1,authorBookRelation.getAuthorId());
				pstmt.setInt(2,authorBookRelation.getBookId());
				
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
			String deleteSQL = "DELETE FROM AUTHOR_BOOK_RELATION WHERE ID=?";
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

















