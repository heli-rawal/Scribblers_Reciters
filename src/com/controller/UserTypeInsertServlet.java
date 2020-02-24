package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.UserTypeBean;
import com.dao.UserTypeDao;
import com.util.ValidationUtils;

public class UserTypeInsertServlet extends HttpServlet {
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
		
		String userType=request.getParameter("userType");
		boolean isError = false;
		UserTypeBean userTypeBean= new UserTypeBean();
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(userType)){
			System.out.println("user type missing");
			request.setAttribute("userType", "<font color=red>*User Type Is Required</font>");
			isError = true;
		}else{
			userTypeBean.setUserType(userType);
		}
		
		if(isError){
			System.out.println("validation error");
			request.getRequestDispatcher("userTypeInsert.jsp").forward(request, response);	
		}else{
						
			if(new UserTypeDao().insert(userTypeBean)){
				System.out.println("User Type Registered..............");
				request.getRequestDispatcher("UserTypeListServlet").forward(request, response);
			}else{
				System.out.println("User Type Registeration Failed..............");
			}
		}
		
	
		
		
	}


	}



