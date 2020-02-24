package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.*;
import java.util.*;
import com.bean.CommentsBean;
import com.dao.CommentsDao;
import com.util.ValidationUtils;

public class CommentsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Get Data
		
		String description = request.getParameter("description");
		
		
		System.out.println("in date try block");
			LocalDate date=LocalDate.now();
			System.out.println("local date"+date);
			
			
				java.sql.Date dateOfCreation=java.sql.Date.valueOf(date);
			
			
		
		
		
		boolean isError = false;
		CommentsBean comments= new CommentsBean();
		
		//Validate & StoreData (Bean)
		
		if(ValidationUtils.isEmpty(description)){
			System.out.println("description not there");
			request.setAttribute("description", "<font color=red>*DESCRIPTION Is Required</font>");
			isError = true;
		}else{
			comments.setDescription(description);
		}
		

		comments.setDateOfCreation(dateOfCreation);
		
		if(isError){
			System.out.println("validation error");
			request.getRequestDispatcher("commentsInsert.jsp").forward(request, response);	
		}else{
						
			if(new CommentsDao().insert(comments)){
				System.out.println("comment inserted..............");
				response.sendRedirect("CommentsListServlet");
				
			}else{
				System.out.println("Comment insertion Failed..............");
			}
		}
		
	
			
		}
	}


	



