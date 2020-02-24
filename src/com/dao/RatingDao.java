package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.RatingBean;
import com.util.DatabaseConnection;

public class RatingDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean insert(RatingBean rating){
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		//ID BY_ID BOOK_ID DATE_OF_CREATION TIME_OF_CREATION REVIEW RATING
		if(conn!=null){
			String insertSQL = "INSERT INTO RATING(DATE_OF_CREATION,RATING)values(?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertSQL);

				
			
				pstmt.setDate(1,rating.getDateOfCreation());
				
				
				pstmt.setString(2,rating.getRating());
				
			
			
				
				
				
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

	public List<RatingBean> select() {
		List<RatingBean> ratingList = new ArrayList<RatingBean>();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM RATING";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				
				RatingBean rating = null;
				while(rs.next()){
					rating = new RatingBean();
					//ID BY_ID BOOK_ID DATE_OF_CREATION TIME_OF_CREATION REVIEW RATING
					rating.setId(rs.getInt("id"));
					rating.setById(rs.getInt("by_id"));
					rating.setBookId(rs.getInt("book_id"));
					
					rating.setDateOfCreation(rs.getDate("date_of_creation"));
					
					rating.setRating(rs.getString("rating"));
					
					
					
					ratingList.add(rating);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return ratingList;
	}

	public RatingBean getRatingByPK(int id) {
		RatingBean rating= new RatingBean();
		
		conn = DatabaseConnection.getDBConnection();
		
		if(conn!=null){
			String selectSQL = "SELECT * FROM RatingBean WHERE ID = ?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()){
					//ID BY_ID BOOK_ID DATE_OF_CREATION TIME_OF_CREATION REVIEW RATING
					rating.setId(rs.getInt("id"));
					rating.setById(rs.getInt("by_id"));
					rating.setBookId(rs.getInt("book_id"));
					
					rating.setDateOfCreation(rs.getDate("date_of_creation"));
					
					rating.setRating(rs.getString("rating"));
					
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return rating;
	}

	public boolean update(RatingBean rating) {
		boolean result = false;
		conn = DatabaseConnection.getDBConnection();
		//ID BY_ID BOOK_ID DATE_OF_CREATION TIME_OF_CREATION REVIEW RATING
		if(conn!=null){
			String updateSQL = "UPDATE Rating SET BY_ID=?, BOOK_ID=?, DATE_OF_CREATION=?,RATING=? WHERE ID=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				
				
				
				pstmt.setInt(1,rating.getById());
				pstmt.setInt(2,rating.getBookId());
				
				pstmt.setDate(3,rating.getDateOfCreation());
				
				pstmt.setString(5, rating.getRating());
				pstmt.setInt(6,rating.getId());
				
				
				
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
			String deleteSQL = "DELETE FROM RATING WHERE ID=?";
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

















