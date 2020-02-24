package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.BookBean;
import com.dao.BookDao;
import com.util.ValidationUtils;

public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//USER(ID,NAME,EMAIL,PASSWORD,SECURITY_QUESTION_ID ,SECURITY_ANSWER,USER_TYPE_ID
		//Get Data
		/*private int id;
 
 private String title;
 private String description;
 
 private String isbn;
 private float price;
p*/
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String isbn = request.getParameter("isbn");
		float price=Float.parseFloat(request.getParameter("price"));
		
		

				boolean isError = false;
		BookBean book= new BookBean();
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(title)){
			System.out.println("title not there");
			request.setAttribute("title", "<font color=red>*FIRST NAME Is Required</font>");
			isError = true;
		}else{
			book.setTitle(title);
		}
		
		if(ValidationUtils.isEmpty(description)){
			System.out.println("description not there");
			request.setAttribute("description", "<font color=red>* PASSWORD Is Required</font>");
			isError = true;
		}else{
			book.setDescription(description);
		}
		
		if(ValidationUtils.isEmpty(isbn)){
			System.out.println("isbn not there");
			request.setAttribute("isbn", "<font color=red>* PASSWORD Is Required</font>");
			isError = true;
		}else{
			book.setIsbn(isbn);
		}
		if(price<=0){
			System.out.println("price not there");
			request.setAttribute("price", "<font color=red>* PASSWORD Is Required</font>");
			isError = true;
		}else{
			book.setPrice(price);
		}
		
		//SECURITY_QUESTION_ID ,SECURITY_ANSWER,USER_TYPE_ID
		
		
		
		
		
		if(isError){
			System.out.println("validation error");
			request.getRequestDispatcher("bookInsert.jsp").forward(request, response);	
		}else{
						
			if(new BookDao().insert(book)){
				System.out.println("Book Registered..............");
				response.sendRedirect("BookListServlet");
			}else{
				System.out.println("Book Registeration Failed..............");
			}
		}
		
	
		
		
	}


	}



