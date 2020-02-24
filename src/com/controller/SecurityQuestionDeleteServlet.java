package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SecurityQuestionDao;


public class SecurityQuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("security quest delete servlet started");
		int securityQuestionId=Integer.parseInt(request.getParameter("securityQuestionId"));
		System.out.println("security Question id "+securityQuestionId);		
		
				if(new SecurityQuestionDao().delete(securityQuestionId)){
			response.sendRedirect("SecurityQuestionListServlet");
			System.out.println("delete successful");
		}else{
			System.out.println(">>>>>>>>>>>>");
			response.sendRedirect("SecurityQuestionListServlet");
		}
		
	}

}
