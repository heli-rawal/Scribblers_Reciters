package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserTypeBean;
import com.dao.UserTypeDao;

public class UserTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("user type edit servlet started");
		int userTypeId= Integer.parseInt(request.getParameter("userTypeId"));
		
		UserTypeBean userTypeBean = new UserTypeDao().getUserTypeByPK(userTypeId);
		
		if(userTypeBean!=null){
			System.out.println("if block");
			request.setAttribute("userTypeBean",userTypeBean);
			request.getRequestDispatcher("userTypeEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in user type edit servlet");
		}
	}

}
