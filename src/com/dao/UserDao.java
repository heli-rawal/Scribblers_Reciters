package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserBean;
import com.util.DatabaseConnection;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(UserBean user){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "insert into user(name,email,password,security_question_id,security_answer,user_type_id)values(?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				//pstmt.setInt(1,user.getId());
				pstmt.setString(1,user.getName());
				pstmt.setString(2,user.getEmail());
				pstmt.setString(3,user.getPassword());
				pstmt.setInt(4,user.getSecurityQuestionId());
				pstmt.setString(5,user.getSecurityAnswer());
				pstmt.setInt(6,user.getUserTypeId());
				
				
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

	public List<UserBean> select() {
		List<UserBean> userList = new ArrayList<UserBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM USER";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				UserBean user = null;
				while(rs.next()){
					user= new UserBean();
					
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setSecurityQuestionId(rs.getInt("security_question_id"));
					user.setSecurityAnswer(rs.getString("security_answer"));
					user.setUserTypeId(rs.getInt("user_type_id"));
					
					userList.add(user);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return userList;
	}

	public UserBean getUserByPK(int id) {
		UserBean user= new UserBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM USER WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setSecurityQuestionId(rs.getInt("security_question_id"));
					user.setSecurityAnswer(rs.getString("security_answer"));
					user.setUserTypeId(rs.getInt("user_type_id"));
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return user;
	}

	public boolean update(UserBean user) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE USER SET name=?,email=?,password=?,security_question_id=?,security_answer=?,user_type_id=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				System.out.println("update method from dao started");
				System.out.println("name "+user.getName());
				System.out.println("email "+user.getEmail());
				System.out.println("password "+user.getPassword());
				System.out.println("sec ques id "+user.getSecurityQuestionId());
				System.out.println("sec ans "+user.getSecurityAnswer());
				System.out.println("user id "+user.getUserTypeId());
				System.out.println("id "+user.getId());
				
				pstmt.setString(1,user.getName());
				pstmt.setString(2,user.getEmail());
				pstmt.setString(3,user.getPassword());
				pstmt.setInt(4,user.getSecurityQuestionId());
				pstmt.setString(5,user.getSecurityAnswer());
				pstmt.setInt(6,user.getUserTypeId());
				pstmt.setInt(7,user.getId());
				
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
			String deleteSQL = "DELETE FROM USER WHERE ID=?";
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
	public ResultSet loginFunction()
	{
			ResultSet resultSet=null;
			conn = DatabaseConnection.getDBConnection();
		
			if(conn!=null){
			String selectSQL = "SELECT * FROM USER";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				resultSet = pstmt.executeQuery();
				
			}
			catch(SQLException e) {
		e.printStackTrace();
		}
	}
			return resultSet;
	
	}
}

















