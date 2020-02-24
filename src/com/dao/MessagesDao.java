package com.dao;
import java.time.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.MessagesBean;
import com.util.*;

public class MessagesDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(MessagesBean messages){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		System.out.println("insert dao");
		
		
		
		//(ID INT(10) PRIMARY KEY AUTO_INCREMENT,DESCRIPTION VARCHAR(255),BY_ID INT(10) REFERENCES USER,TO_ID INT(10) REFERENCES AUTHOR,IS_DELETED boolean default false,DATE_OF_CREATION DATE NOT NULL);
		if(conn!=null){
			String insertSQL = "INSERT INTO MESSAGES(DESCRIPTION,DATE_OF_CREATION)values(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				//LocalDate.now()			
				pstmt.setString(1,messages.getDescription());
				
				pstmt.setDate(2,messages.getDateOfCreation());
			
			
			
				
				
				
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

	public List<MessagesBean> select() {
		List<MessagesBean> messagesList = new ArrayList<MessagesBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM messages";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				MessagesBean messages= null;
				while(rs.next()){
					messages= new MessagesBean();
					//ID DESCRIPTION BY_ID TO_ID IS_DELETED DATE_OF_CREATION TIME_OF_CREATION
					messages.setId(rs.getInt("id"));
					messages.setDescription(rs.getString("description"));
					messages.setById(rs.getInt("by_id"));
					messages.setToId(rs.getInt("to_id"));
					
					messages.setDateOfCreation(rs.getDate("date_of_creation"));
					/*
					 LocalDate date=comments.getDateOfCreation();
				pstmt.setDate(4, java.sql.Date.valueOf(date));*/
					
					
					messagesList.add(messages);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return messagesList;
	}

	public MessagesBean getMessagesByPK(int id) {
		MessagesBean messages= new MessagesBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM messages WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					messages.setId(rs.getInt("id"));
					messages.setDescription(rs.getString("description"));
					messages.setById(rs.getInt("by_id"));
					messages.setToId(rs.getInt("to_id"));

					messages.setDateOfCreation(rs.getDate("date_of_creation"));
					
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return messages;
	}

	public boolean update(MessagesBean messages) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		//ID DESCRIPTION BY_ID TO_ID IS_DELETED DATE_OF_CREATION TIME_OF_CREATION
		if(conn!=null){
			String updateSQL = "UPDATE messages SET DESCRIPTION=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setString(1,messages.getDescription());
				
				pstmt.setInt(2, messages.getId());
				
				
				
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
			String deleteSQL = "DELETE FROM MESSAGES WHERE ID=?";
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

















