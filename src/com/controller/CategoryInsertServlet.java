package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.CategoryBean;
import com.dao.CategoryDao;
import com.util.ValidationUtils;

public class CategoryInsertServlet extends HttpServlet {
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
		System.out.println("category insert servlet started");
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		boolean isError = false;
		CategoryBean categoryBean= new CategoryBean();
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(name)){
			System.out.println("category name missing");
			request.setAttribute("name", "<font color=red>*Category name Is Required</font>");
			isError = true;
		}else{
			categoryBean.setName(name);
		}
		
			categoryBean.setDescription(description);
		
		if(isError){
			System.out.println("validation error");
			request.getRequestDispatcher("categoryInsert.jsp").forward(request, response);	
		}else{
						
			if(new CategoryDao().insert(categoryBean)){
			
				System.out.println("Category Registered..............");
				response.sendRedirect("CategoryListServlet");
			}else{
				System.out.println("Category Registeration Failed..............");
			}
		}
		
	
		
		
	}


	}



