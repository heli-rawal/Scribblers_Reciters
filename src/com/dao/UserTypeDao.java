package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserTypeBean;
import com.bean.UserBean;
import com.util.DatabaseConnection;

public class UserTypeDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//Insert
	public boolean insert(UserTypeBean userTypeBean){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "insert into user_type(user_type)values(?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				//pstmt.setInt(1,user.getId());
				pstmt.setString(1,userTypeBean.getUserType());
				
				
				
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


	//Delete
	//Update
	//getByPK
	
	public List<UserTypeBean> select() {
		List<UserTypeBean> userTypeList = new ArrayList<UserTypeBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM user_type";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				UserTypeBean userTypeBean = null;
				while(rs.next()){
					userTypeBean = new UserTypeBean();

					userTypeBean.setUserTypeId(Integer.parseInt(rs.getString("user_type_id")));
					userTypeBean.setUserType(rs.getString("user_type"));
					
					userTypeList.add(userTypeBean);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return userTypeList;
	}
	public UserTypeBean getUserTypeByPK(int id) {
		UserTypeBean userTypeBean= new UserTypeBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM USER_TYPE WHERE USER_TYPE_ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					
					userTypeBean.setUserTypeId(rs.getInt("user_type_id"));
					userTypeBean.setUserType(rs.getString("user_type"));
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return userTypeBean;
	}

	public boolean update(UserTypeBean userTypeBean) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE USER_TYPE SET user_type=? WHERE user_type_id=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				System.out.println("update method from dao started");
				System.out.println(userTypeBean.getUserType());
				System.out.println(userTypeBean.getUserTypeId());
				
				pstmt.setString(1,userTypeBean.getUserType());
				pstmt.setInt(2,userTypeBean.getUserTypeId());
				
				
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
			String deleteSQL = "DELETE FROM USER_TYPE WHERE USER_TYPE_ID=?";
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




