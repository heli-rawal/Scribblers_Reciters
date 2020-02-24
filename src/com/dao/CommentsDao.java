package com.dao;
import java.time.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CommentsBean;
import com.util.*;

public class CommentsDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(CommentsBean comments){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		System.out.println("insert dao");
		
		
		
		//(ID INT(10) PRIMARY KEY AUTO_INCREMENT,DESCRIPTION VARCHAR(255),BY_ID INT(10) REFERENCES USER,TO_ID INT(10) REFERENCES AUTHOR,IS_DELETED boolean default false,DATE_OF_CREATION DATE NOT NULL);
		if(conn!=null){
			String insertSQL = "INSERT INTO COMMENTS(DESCRIPTION,DATE_OF_CREATION)values(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				//LocalDate.now()			
				pstmt.setString(1,comments.getDescription());
				
				pstmt.setDate(2,comments.getDateOfCreation());
			
			
			
				
				
				
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

	public List<CommentsBean> select() {
		List<CommentsBean> commentsList = new ArrayList<CommentsBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM COMMENTS";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				CommentsBean comments= null;
				while(rs.next()){
					comments= new CommentsBean();
					//ID DESCRIPTION BY_ID TO_ID IS_DELETED DATE_OF_CREATION TIME_OF_CREATION
					comments.setId(rs.getInt("id"));
					comments.setDescription(rs.getString("description"));
					comments.setById(rs.getInt("by_id"));
					comments.setToId(rs.getInt("to_id"));
					
					comments.setDateOfCreation(rs.getDate("date_of_creation"));
					/*
					 LocalDate date=comments.getDateOfCreation();
				pstmt.setDate(4, java.sql.Date.valueOf(date));*/
					
					
					commentsList.add(comments);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return commentsList;
	}

	public CommentsBean getCommentsByPK(int id) {
		CommentsBean comments= new CommentsBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM COMMENTS WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					comments.setId(rs.getInt("id"));
					comments.setDescription(rs.getString("description"));
					comments.setById(rs.getInt("by_id"));
					comments.setToId(rs.getInt("to_id"));

					comments.setDateOfCreation(rs.getDate("date_of_creation"));
					
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return comments;
	}

	public boolean update(CommentsBean comments) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		//ID DESCRIPTION BY_ID TO_ID IS_DELETED DATE_OF_CREATION TIME_OF_CREATION
		if(conn!=null){
			String updateSQL = "UPDATE COMMENTS SET DESCRIPTION=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setString(1,comments.getDescription());
				
				pstmt.setInt(2, comments.getId());
				
				
				
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
			String deleteSQL = "DELETE FROM COMMENTS WHERE ID=?";
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

















