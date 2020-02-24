package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CategoryBean;
import com.util.DatabaseConnection;

public class CategoryDao {
	//id name description
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(CategoryBean category){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO Category(name,description)values(?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				pstmt.setString(1,category.getName());
				pstmt.setString(2,category.getDescription());
				
				
				
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

	public List<CategoryBean> select() {
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Category";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				CategoryBean category= null;
				while(rs.next()){
					category= new CategoryBean();
					
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setDescription(rs.getString("description"));
					
					categoryList.add(category);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return categoryList;
	}

	public CategoryBean getCategoryByPK(int id) {
		CategoryBean category= new CategoryBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Category WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setDescription(rs.getString("description"));
					
						}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return category;
	}

	public boolean update(CategoryBean category) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE CATEGORY SET NAME=?,DESCRIPTION=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setString(1,category.getName());
				pstmt.setString(2,category.getDescription());
				pstmt.setInt(3,category.getId());
				
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
			String deleteSQL = "DELETE FROM CATEGORY WHERE ID=?";
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

















