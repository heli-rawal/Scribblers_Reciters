package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RatingDao;


public class RatingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("rating delete servlet started");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);		
				if(new RatingDao().delete(id)){
			response.sendRedirect("RatingListServlet");
			System.out.println("delete successful");
		}else{
			response.sendRedirect("RatingListServlet");
		}
		
	}

}
