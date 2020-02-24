package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessagesDao;


public class MessagesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("messages delete servlet started");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);		
				if(new MessagesDao().delete(id)){
			response.sendRedirect("MessagesListServlet");
			System.out.println("delete successful");
		}else{
			response.sendRedirect("MessagesListServlet");
		}
		
	}

}
