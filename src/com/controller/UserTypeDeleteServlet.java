package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserTypeDao;


public class UserTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("user type delete servlet started");
		int userTypeId=Integer.parseInt(request.getParameter("userTypeId"));
		System.out.println("user type id "+userTypeId);		
				if(new UserTypeDao().delete(userTypeId)){
			response.sendRedirect("UserTypeListServlet");
			System.out.println("delete successful");
		}else{
			response.sendRedirect("UserTypeListServlet");
		}
		
	}

}
