package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("user edit servlet started");
		UserBean user = new UserDao().getUserByPK(id);
		
		if(user!=null){
			System.out.println("if block");
			request.setAttribute("user",user);
			request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in user edit servlet");
		}
	}

}
