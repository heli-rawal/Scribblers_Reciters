package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.SecurityQuestionBean;
import com.dao.SecurityQuestionDao;
import com.util.ValidationUtils;

public class SecurityQuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//private int userTypeId;
		//private String userType;
		
		//Get Data
		System.out.println("security question insert servlet started");
		String securityQuestion=request.getParameter("securityQuestion");
		boolean isError = false;
		SecurityQuestionBean securityQuestionBean= new SecurityQuestionBean();
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(securityQuestion)){
			System.out.println("security Question");
			request.setAttribute("securityQuestion", "<font color=red>*security Question Is Required</font>");
			isError = true;
		}else{
			securityQuestionBean.setSecurityQuestion(securityQuestion);
		}
		
		
		if(isError){
			System.out.println("validation error");
			request.getRequestDispatcher("securityQuestionInsert.jsp").forward(request, response);	
		}else{
						System.out.println("predecing dao call for insert");
			if(new SecurityQuestionDao().insert(securityQuestionBean)){
				System.out.println("Security question Registered..............");
				response.sendRedirect("SecurityQuestionListServlet");
			}else{
				System.out.println("Security question Registeration Failed..............");
			}
		}
		
	
		
		
	}


	}



