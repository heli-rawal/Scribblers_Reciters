package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.dao.CategoryDao;
import com.util.ValidationUtils;


public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Category update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		//System.out.println("id "+id);
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
	
		
	
		boolean isError = false;
		CategoryBean categoryBean= new CategoryBean();
		categoryBean.setId(id);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(name)){
			System.out.println(" name not there");
			request.setAttribute("name", "<font color=red>*CATEGORY NAME Is Required</font>");
			isError = true;
		}else{
			categoryBean.setName(name);
		}
			categoryBean.setDescription(description);
		
		if(isError){
			request.getRequestDispatcher("categoryEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new CategoryDao().update(categoryBean)){
				System.out.println("Update of category successful..............");
				response.sendRedirect("CategoryListServlet");
			}else{
				System.out.println("Category Updation Failed..............");
				response.sendRedirect("CategoryListServlet");
			}
		}
		
		
		
		
	}

}


