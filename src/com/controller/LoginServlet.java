package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userTypeId = request.getParameter("userTypeId");
		
	/*	if(userTypeId.equals("admin")){
			AdminBean admin = new ADminDAO().authenticateUser(email,pwd);
			if(admin!=null){
			 HttpSession session = request.getSession();
			 
			 session.setAttribute("admin",admin);
			 
			 //Call Admin Home Page
			}
		}else if(userTypeId.equals("emoployee")){
			EmployeeBean employee = new EmployeeDAO().authenticateUser(email,pwd);
		}*/
		
		
//		HttpSession session = request.getSession(true);
//		System.out.println(session.isNew());
	/*	if(session.isNew()){
		 response.getWriter().write("<h2>WELCOME USER</h2>");
		}else {
			response.getWriter().write("<h2>WELCOME Back</h2>");
		}*/
		
		//Static Code
		//1 2 8 9
		//resultset
		ResultSet rs = new UserDao().loginFunction();
		int i=0;
		String emailData;
		String passwordData;
		try {
			while(rs.next()){
				emailData=rs.getString("email");
				passwordData=rs.getString("password");
				if(email.equals(emailData)&&password.equals(passwordData))
				{
					i=1;
				}
			}
		
			if(i==1)
			{
				System.out.println("Login Success.......");

			HttpSession session = request.getSession();//Start Users Session
			System.out.println("session created");
			session.setAttribute("email","email");
			if(userTypeId.equals("1")){
				System.out.println("admin");
				response.sendRedirect("adminHome.jsp");
				
			}else if(userTypeId.equals("2")){
				System.out.println("author");
				response.sendRedirect("authorHome.jsp");
				
			}else if(userTypeId.equals("8")){
				System.out.println("reader");
				response.sendRedirect("readerHome.jsp");
				
			}
			else if(userTypeId.equals("9")){
				System.out.println("publisher");
				response.sendRedirect("publisherHome.jsp");
				
			}
			else{
				response.sendRedirect("userLogin.jsp");
				
			}
			
/*			session.setAttribute("manager", "manager@gmail.com");
			session.setAttribute("customer", "customer@gmail.com");
*/
			}
		else {
			response.sendRedirect("userLogin.jsp");
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
