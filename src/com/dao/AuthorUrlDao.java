package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.AuthorUrlBean;
import com.util.DatabaseConnection;

public class AuthorUrlDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(AuthorUrlBean authorUrl){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO Author_Url(author_description_id,url)values(?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
				pstmt.setInt(1,authorUrl.getAuthorDescriptionId());
				pstmt.setString(2,authorUrl.getUrl());
				
				
				
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

	public List<AuthorUrlBean> select() {
		List<AuthorUrlBean> authorUrlList = new ArrayList<AuthorUrlBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM Author_Url";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				AuthorUrlBean authorUrl= null;
				while(rs.next()){
					authorUrl= new AuthorUrlBean();
					
					authorUrl.setId(rs.getInt("id"));
					authorUrl.setAuthorDescriptionId(rs.getInt("author_description_id"));
					authorUrl.setUrl(rs.getString("url"));
					
					
					
					authorUrlList.add(authorUrl);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return authorUrlList;
	}

	public AuthorUrlBean getAuthorUrlByPK(int id) {
		AuthorUrlBean authorUrl= new AuthorUrlBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM AUTHOR_Url WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					authorUrl.setId(rs.getInt("id"));
					authorUrl.setAuthorDescriptionId(rs.getInt("author_description_id"));
					authorUrl.setUrl(rs.getString("url"));
					
						}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return authorUrl;
	}

	public boolean update(AuthorUrlBean authorUrl) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE AUTHOR_Url SET AUTHOR_description_ID=?,Url=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				pstmt.setInt(1,authorUrl.getAuthorDescriptionId());
				pstmt.setString(2,authorUrl.getUrl());
				pstmt.setInt(3,authorUrl.getId());
				
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
			String deleteSQL = "DELETE FROM AUTHOR_pstmt.setString(2,authorUrl.getUrl()); WHERE ID=?";
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

















