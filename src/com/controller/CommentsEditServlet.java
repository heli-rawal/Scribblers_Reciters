package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CommentsBean;
import com.dao.CommentsDao;

public class CommentsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("Comments edit servlet started");
		System.out.println(id);
		CommentsBean comments = new CommentsDao().getCommentsByPK(id);
		
		if(comments!=null){
			System.out.println("if block");
			request.setAttribute("comments",comments);
			request.getRequestDispatcher("commentsEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in comments edit servlet");
		}
	}

}
