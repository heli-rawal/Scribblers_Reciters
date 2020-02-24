package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RatingBean;
import com.dao.RatingDao;
import com.util.ValidationUtils;


public class RatingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ratings update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);
		
		String description = request.getParameter("description");
	
		
	
		boolean isError = false;
		RatingBean ratingsBean= new RatingBean();
		ratingsBean.setId(id);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(description)){
			System.out.println("description name not there");
			request.setAttribute("description", "<font color=red>*description Is Required</font>");
			isError = true;
		}else{
			ratingsBean.setRating(description);
		}
		
		if(isError){
			request.getRequestDispatcher("ratingsEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new RatingDao().update(ratingsBean)){
				System.out.println("Update rating successful..............");
				response.sendRedirect("RatingListServlet");
			}else{
				System.out.println("rating Updation Failed..............");
				response.sendRedirect("RatingListServlet");
			}
		}
		
		
		
		
	}

}


