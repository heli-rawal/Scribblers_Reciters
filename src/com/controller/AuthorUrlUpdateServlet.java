package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AuthorUrlBean;
import com.dao.AuthorUrlDao;
import com.util.ValidationUtils;


public class AuthorUrlUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("authorUrl update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("id "+id);
		
		String url = request.getParameter("url");
		int AuthorDescriptionId=Integer.parseInt(request.getParameter("AuthorDescriptionId"));
	
		
	
		boolean isError = false;
		AuthorUrlBean authorUrlBean= new AuthorUrlBean();
		authorUrlBean.setId(id);
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(url)){
			System.out.println("url not there");
			request.setAttribute("url", "<font color=red>*url Is Required</font>");
			isError = true;
		}else{
			authorUrlBean.setUrl(url);
		}
		if(ValidationUtils.isEmpty(AuthorDescriptionId)){
			System.out.println("AuthorDescriptionId not there");
			request.setAttribute("AuthorDescriptionId", "<font color=red>*url Is Required</font>");
			isError = true;
		}else{
			authorUrlBean.setAuthorDescriptionId(AuthorDescriptionId);
		}
		
		if(isError){
			request.getRequestDispatcher("authorUrlEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			
			if(new AuthorUrlDao().update(authorUrlBean)){
				System.out.println("Update comment successful..............");
				response.sendRedirect("AuthorUrlListServlet");
			}else{
				System.out.println("comment Updation Failed..............");
				response.sendRedirect("AuthorUrlListServlet");
			}
		}
		
		
		
		
	}

}


