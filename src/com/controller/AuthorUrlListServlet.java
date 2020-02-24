package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.AuthorUrlBean;
import com.dao.AuthorUrlDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class AuthorUrlListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("authorUrl list started");
		List<AuthorUrlBean> authorUrlList = new AuthorUrlDao().select();
		
		if(authorUrlList!=null){
			
			
			request.setAttribute("authorUrlList", authorUrlList);	
			request.getRequestDispatcher("authorUrlList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
		
	
	
		
		
	}
}