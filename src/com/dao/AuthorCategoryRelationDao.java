package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.AuthorCategoryRelationBean;
import com.util.DatabaseConnection;

public class AuthorCategoryRelationDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(AuthorCategoryRelationBean authorCategoryRelation){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO Author_Category_Relation(author_id,Catogory_id)values(?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				pstmt.setInt(1,authorCategoryRelation.getAuthorId());
				pstmt.setInt(2,authorCategoryRelation.getCategoryId());
				
				
				
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

	public List<AuthorCategoryRelationBean> select() {
		List<AuthorCategoryRelationBean> authorCategoryRelationList = new ArrayList<AuthorCategoryRelationBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Author_Category_Relation";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				AuthorCategoryRelationBean authorCategoryRelation = null;
				while(rs.next()){
					authorCategoryRelation= new AuthorCategoryRelationBean();
					
					authorCategoryRelation.setId(rs.getInt("id"));
					authorCategoryRelation.setAuthorId(rs.getInt("author_id"));
					authorCategoryRelation.setCategoryId(rs.getInt("category_id"));
					
					
					
					authorCategoryRelationList.add(authorCategoryRelation);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return authorCategoryRelationList;
	}

	public AuthorCategoryRelationBean getAuthorCategoryRelationByPK(int id) {
		AuthorCategoryRelationBean authorCategoryRelation= new AuthorCategoryRelationBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM AUTHOR_Category_RELATION WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					authorCategoryRelation.setId(rs.getInt("id"));
					authorCategoryRelation.setId(rs.getInt("author_id"));
					authorCategoryRelation.setId(rs.getInt("book_id"));
					
						}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return authorCategoryRelation;
	}

	public boolean update(AuthorCategoryRelationBean authorCategoryRelation) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE AUTHOR_Category_RELATION SET AUTHOR_ID=?,BOOK_ID=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setInt(1,authorCategoryRelation.getAuthorId());
				pstmt.setInt(2,authorCategoryRelation.getCategoryId());
				
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
			String deleteSQL = "DELETE FROM AUTHOR_Category_RELATION WHERE ID=?";
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

















