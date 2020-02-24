package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SecurityQuestionBean;
import com.dao.SecurityQuestionDao;

public class SecurityQuestionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Security Question edit servlet started");
		int securityQuestionId= Integer.parseInt(request.getParameter("securityQuestionId"));
		
		SecurityQuestionBean securityQuestionBean = new SecurityQuestionDao().getSecurityQuestionByPK(securityQuestionId);
		
		if(securityQuestionBean!=null){
			System.out.println("forwarding to jsp from edit servlet");
			request.setAttribute("securityQuestionBean",securityQuestionBean);
			request.getRequestDispatcher("securityQuestionEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in security ques edit servlet");
		}
	}

}
