package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SecurityQuestionBean;
import com.dao.SecurityQuestionDao;
import com.util.ValidationUtils;


public class SecurityQuestionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Security Question update servlet started");
		//Get Data
		int securityQuestionId= Integer.parseInt(request.getParameter("securityQuestionId"));
		//System.out.println("id "+id);
		
		String securityQuestion = request.getParameter("securityQuestion");
	
		
	
		boolean isError = false;
		SecurityQuestionBean securityQuestionBean= new SecurityQuestionBean();
		securityQuestionBean.setSecurityQuestionId(securityQuestionId);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(securityQuestion)){
			System.out.println("security Question name not there");
			request.setAttribute("securityQuestion", "<font color=red>*security Question Is Required</font>");
			isError = true;
		}else{
			securityQuestionBean.setSecurityQuestion(securityQuestion);
		}
		
		if(isError){
			request.getRequestDispatcher("securityQuestionEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new SecurityQuestionDao().update(securityQuestionBean)){
				System.out.println("Update of security Question successful..............");
				response.sendRedirect("SecurityQuestionListServlet");
			}else{
				System.out.println("security ques updation Failed..............");
				response.sendRedirect("SecurityQuestionListServlet");
			}
		}
		
		
		
		
	}

}


