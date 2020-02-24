package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserTypeBean;
import com.dao.UserTypeDao;
import com.util.ValidationUtils;


public class UserTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("user type update servlet started");
		//Get Data
		int userTypeId= Integer.parseInt(request.getParameter("userTypeId"));
		//System.out.println("id "+id);
		
		String userType = request.getParameter("userType");
	
		
	
		boolean isError = false;
		UserTypeBean userTypeBean= new UserTypeBean();
		userTypeBean.setUserTypeId(userTypeId);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(userType)){
			System.out.println("user type name not there");
			request.setAttribute("userType", "<font color=red>*USER TYPE Is Required</font>");
			isError = true;
		}else{
			userTypeBean.setUserType(userType);
		}
		
		if(isError){
			request.getRequestDispatcher("userTypeEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new UserTypeDao().update(userTypeBean)){
				System.out.println("Update of user type successful..............");
				response.sendRedirect("UserTypeListServlet");
			}else{
				System.out.println("User Updation Failed..............");
				response.sendRedirect("UserTypeListServlet");
			}
		}
		
		
		
		
	}

}


