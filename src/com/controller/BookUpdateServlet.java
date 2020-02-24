package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;
import com.util.ValidationUtils;


public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("book update servlet started");
		//Get Data
		int id= Integer.parseInt(request.getParameter("id"));
		//System.out.println("id "+id);
		
		String title = request.getParameter("title");
	//	System.out.println("name "+name);
		String description = request.getParameter("description");
		//System.out.println("email "+email);
		String isbn = request.getParameter("isbn");
		float price=Float.parseFloat(request.getParameter("price"));
		boolean isError = false;
		BookBean book= new BookBean();
		//Validate & StoreData (Bean)
		if(ValidationUtils.isEmpty(title)){
			System.out.println("title not there");
			request.setAttribute("title", "<font color=red>*title NAME Is Required</font>");
			isError = true;
		}else{
			book.setTitle(title);
		}
		
		if(ValidationUtils.isEmpty(description)){
			System.out.println("description not there");
			request.setAttribute("description", "<font color=red>*description NAME Is Required</font>");
			isError = true;
		}else{
			book.setTitle(description);
		}
			
		if(ValidationUtils.isEmpty(isbn)){
			System.out.println("isbn not there");
			request.setAttribute("isbn", "<font color=red>*isbn NAME Is Required</font>");
			isError = true;
		}else{
			book.setTitle(isbn);
		}
		
		if(price<=0){
			System.out.println("price not there");
			request.setAttribute("price", "<font color=red>*price Is Required</font>");
			isError = true;
		}else{
			book.setPrice(price);
		}
		
		
			if(isError){
			request.setAttribute("book", book);
			request.getRequestDispatcher("bookEdit.jsp").forward(request, response);	
			System.out.println("validation error");
		}else{
			//Transaction
			book.setId(id);
			if(new BookDao().update(book)){
				System.out.println("Update successful..............");
				response.sendRedirect("BookListServlet");
			}else{
				System.out.println("Book Updation Failed..............");
				response.sendRedirect("BookListServlet");
			}
		}
		
		
		
		
	}

}


