package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.UserBean;
import com.dao.UserDao;
import com.util.ValidationUtils;

public class UserInsertServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//USER(ID,NAME,EMAIL,PASSWORD,SECURITY_QUESTION_ID ,SECURITY_ANSWER,USER_TYPE_ID
		//Get Data
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		

		String securityAnswer=request.getParameter("securityAnswer");
		
		
		System.out.println("name "+name);
		System.out.println("email "+email);
		System.out.println("password "+password);

		System.out.println("ans "+securityAnswer);
		int userTypeId= Integer.parseInt(request.getParameter("userTypeId"));
		System.out.println("user type "+userTypeId);
		int securityQuestionId=Integer.parseInt(request.getParameter("securityQuestionId"));
		System.out.println("s ques id "+securityQuestionId);
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
			System.out.println("validation error");
			request.getRequestDispatcher("UserInsert1.jsp").forward(request, response);	
		}else{
						
			if(new UserDao().insert(user)){
				System.out.println("User Registered..............");
				request.getRequestDispatcher("UserListServlet").forward(request, response);
			}else{
				System.out.println("User Registeration Failed..............");
			}
		}
		
	
		
		
	}


	}



