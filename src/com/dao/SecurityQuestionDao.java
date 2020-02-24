package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.SecurityQuestionBean;
import com.util.DatabaseConnection;

public class SecurityQuestionDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(SecurityQuestionBean securityQuestion){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO Security_Question(question)values(?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				pstmt.setString(1,securityQuestion.getSecurityQuestion());
				
				
				
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

	public List<SecurityQuestionBean> select() {
		List<SecurityQuestionBean> securityQuestionList = new ArrayList<SecurityQuestionBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM SECURITY_QUESTION";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				SecurityQuestionBean securityQuestion = null;
				while(rs.next()){
					securityQuestion= new SecurityQuestionBean();
					
					securityQuestion.setSecurityQuestionId(rs.getInt("id"));
					securityQuestion.setSecurityQuestion(rs.getString("question"));
					
					securityQuestionList.add(securityQuestion);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return securityQuestionList;
	}

	public SecurityQuestionBean getSecurityQuestionByPK(int id) {
		SecurityQuestionBean securityQuestion= new SecurityQuestionBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM SECURITY_QUESTION WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					securityQuestion.setSecurityQuestionId(rs.getInt("id"));
					securityQuestion.setSecurityQuestion(rs.getString("question"));
					
						}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return securityQuestion;
	}

	public boolean update(SecurityQuestionBean securityQuestion) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE SECURITY_QUESTION SET QUESTION=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setString(1,securityQuestion.getSecurityQuestion());
				pstmt.setInt(2,securityQuestion.getSecurityQuestionId());
				
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
		System.out.println("****************");
		System.out.println("security ques DAO started");
		System.out.println("****************");
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String deleteSQL = "DELETE FROM SECURITY_QUESTION WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);


				pstmt.setInt(1, id);
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected>0){
					result = true;
					System.out.println("Delete Successful...........");
					
				}else{
					System.out.println("Delete Failed ----> dao...........");
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	
}

















