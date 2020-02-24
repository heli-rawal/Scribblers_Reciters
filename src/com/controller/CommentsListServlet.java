package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.CommentsBean;
import com.dao.CommentsDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class CommentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("comments list started");
		List<CommentsBean> commentsList = new CommentsDao().select();
		
		if(commentsList!=null){
			
			
			request.setAttribute("commentsList", commentsList);	
			request.getRequestDispatcher("commentsList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}