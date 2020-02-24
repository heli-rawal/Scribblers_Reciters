package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.ValidationUtils;


public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("user update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		//System.out.println("id "+id);
		
		String name = request.getParameter("name");
	//	System.out.println("name "+name);
		String email = request.getParameter("email");
		//System.out.println("email "+email);
		String password = request.getParameter("password");
		//System.out.println("password "+password);
		int securityQuestionId=Integer.parseInt(request.getParameter("securityQuestionId"));
		//System.out.println("security ques id "+securityQuestionId);
		String securityAnswer=request.getParameter("securityAnswer");
		//System.out.println("security Answer "+securityAnswer);
		int userTypeId= Integer.parseInt(request.getParameter("userTypeId"));
		//System.out.println("user type id "+userTypeId);	
	
		
	
		boolean isError = false;
		UserBean user= new UserBean();
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(name)){
			System.out.println("name not there");
			request.setAttribute("name", "<font color=red>*FIRST NAME Is Required</font>");
			isError = true;
		}else{
			user.setName(name);
		}
		
		int result=ValidationUtils.email(email);
		if(result==1){
			System.out.println("format incorrect");
			request.setAttribute("email", "<font color=red>* email not there or format incorrect </font>");
			isError = true;
		}
		else if(result==2){
			System.out.println("email not there");
			request.setAttribute("email", "<font color=red>* email not there or format incorrect </font>");
			isError = true;
		}
		else{
			user.setEmail(email);
		}
			
		if(ValidationUtils.isEmpty(password)){
			System.out.println("password not there");
			request.setAttribute("password", "<font color=red>* PASSWORD Is Required</font>");
			isError = true;
		}else{
			user.setPassword(password);
		}
		
		
		//SECURITY_QUESTION_ID ,SECURITY_ANSWER,USER_TYPE_ID
		if(ValidationUtils.isEmpty(securityQuestionId)){
			System.out.println("securityQuestionId not there");
			request.setAttribute("securityQuestionId", "<font color=red>*SECURITY QUESTION  Is Required</font>");
			isError = true;
		}else{
			user.setSecurityQuestionId(securityQuestionId);
		}
		
		if(ValidationUtils.isEmpty(securityAnswer))
		{
			System.out.println("security ans not there");
			request.setAttribute("securityAnswer", "<font color=red>*SECURITY ANSWER  Is Required</font>");
			isError = true;
		}else{
			user.setSecurityAnswer(securityAnswer);
		}
		
		if(ValidationUtils.isEmpty(userTypeId)){
			System.out.println("user type not there");
			request.setAttribute("userTypeId", "<font color=red>*USER TYPE  Is Required</font>");
			isError = true;
		}else{
			user.setUserTypeId(userTypeId);
		}
		
		
	if(isError){
			request.setAttribute("user", user);
			request.getRequestDispatcher("UserEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			user.setId(id);
			if(new UserDao().update(user)){
				System.out.println("Update successful..............");
				response.sendRedirect("UserListServlet");
			}else{
				System.out.println("User Updation Failed..............");
				response.sendRedirect("UserListServlet");
			}
		}
		
		
		
		
	}

}


