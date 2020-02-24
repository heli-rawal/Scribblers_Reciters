package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MessagesBean;
import com.dao.MessagesDao;
import com.util.ValidationUtils;


public class MessagesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Messages update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);
		
		String description = request.getParameter("description");
	
		
	
		boolean isError = false;
		MessagesBean messagesBean= new MessagesBean();
		messagesBean.setId(id);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(description)){
			System.out.println("description name not there");
			request.setAttribute("description", "<font color=red>*description Is Required</font>");
			isError = true;
		}else{
			messagesBean.setDescription(description);
		}
		
		if(isError){
			request.getRequestDispatcher("messagesEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new MessagesDao().update(messagesBean)){
				System.out.println("Update messages successful..............");
				response.sendRedirect("MessagesListServlet");
			}else{
				System.out.println("meessages Updation Failed..............");
				response.sendRedirect("MessagesListServlet");
			}
		}
		
		
		
		
	}

}


