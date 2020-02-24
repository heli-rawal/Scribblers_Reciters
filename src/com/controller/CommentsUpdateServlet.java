package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CommentsBean;
import com.dao.CommentsDao;
import com.util.ValidationUtils;


public class CommentsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("comments update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);
		
		String description = request.getParameter("description");
	
		
	
		boolean isError = false;
		CommentsBean commentsBean= new CommentsBean();
		commentsBean.setId(id);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(description)){
			System.out.println("description name not there");
			request.setAttribute("description", "<font color=red>*description Is Required</font>");
			isError = true;
		}else{
			commentsBean.setDescription(description);
		}
		
		if(isError){
			request.getRequestDispatcher("commentsEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new CommentsDao().update(commentsBean)){
				System.out.println("Update comment successful..............");
				response.sendRedirect("CommentsListServlet");
			}else{
				System.out.println("comment Updation Failed..............");
				response.sendRedirect("CommentsListServlet");
			}
		}
		
		
		
		
	}

}


