package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;


public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		System.out.println("category delete servlet started");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);		
		if(new CategoryDao().delete(id)){
			response.sendRedirect("CategoryListServlet");
			System.out.println("delete successful");
		}else{
			response.sendRedirect("CategoryListServlet");
		}
		
	}

}
