package com.util;

import java.sql.Connection;
import java.time.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static String connectionURL = "jdbc:mysql://localhost:3306/SR";
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "admin";

	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName);// Load's driver class

			 conn = DriverManager.getConnection(connectionURL,userName,password);

			if(conn!=null){
				System.out.println("Database Connected....");
			}else{
				System.out.println("Connection Failure.......");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println("app started");
		DatabaseConnection.getDBConnection();
		//System.out.println(LocalDate.now());
		//LocalDate date=LocalDate.now();
		//System.out.println(date);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
