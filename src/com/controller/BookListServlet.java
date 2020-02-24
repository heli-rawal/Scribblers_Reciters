package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.BookBean;
import com.dao.BookDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BookBean> bookList = new BookDao().select();
		
		if(bookList!=null){
			
			
			request.setAttribute("bookList", bookList);	
			request.getRequestDispatcher("bookList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}