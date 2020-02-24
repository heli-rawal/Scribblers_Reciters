package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.dao.CategoryDao;

public class CategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("category edit servlet started");
		int id= Integer.parseInt(request.getParameter("id"));
		
		CategoryBean categoryBean= new CategoryDao().getCategoryByPK(id);
		
		if(categoryBean!=null){
			System.out.println("if block");
			request.setAttribute("categoryBean",categoryBean);
			request.getRequestDispatcher("categoryEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in category edit servlet");
		}
	}

}
