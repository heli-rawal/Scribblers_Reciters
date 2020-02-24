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
import com.bean.AuthorUrlBean;
import com.dao.AuthorUrlDao;
import com.util.ValidationUtils;

public class AuthorUrlInsertServlet extends HttpServlet {
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
		
		String url = request.getParameter("url");
		int authorDescriptionId=Integer.parseInt(request.getParameter("authorDescriptionId"));
		boolean isError = false;
		AuthorUrlBean authorUrl= new AuthorUrlBean();
		
		//Validate & StoreData (Bean)
		
		if(ValidationUtils.isEmpty(url)){
			System.out.println("url not there");
			request.setAttribute("url", "<font color=red>*DESCRIPTION Is Required</font>");
			isError = true;
		}else{
			authorUrl.setUrl(url);
		}
		if(ValidationUtils.isEmpty(authorDescriptionId)){
			System.out.println("authorDescriptionId not there");
			request.setAttribute("authorDescriptionId", "<font color=red>*DESCRIPTION Is Required</font>");
			isError = true;
		}else{
			authorUrl.setAuthorDescriptionId(authorDescriptionId);
		}

	
		
		if(isError){
			System.out.println("validation error");
			request.getRequestDispatcher("authorUrlInsert.jsp").forward(request, response);	
		}else{
						
			if(new AuthorUrlDao().insert(authorUrl)){
				System.out.println("authorUrl inserted..............");
				response.sendRedirect("AuthorUrlListServlet");
				
			}else{
				System.out.println("url insertion Failed..............");
			}
		}
		
	
			
		}
	}


	



