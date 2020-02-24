package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;

public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("book edit servlet started");
		BookBean book = new BookDao().getBookByPK(id);
		
		if(book!=null){
			System.out.println("if block");
			request.setAttribute("book",book);
			request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in book edit servlet");
		}
	}

}
