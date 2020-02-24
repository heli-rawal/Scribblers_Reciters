package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AuthorUrlBean;
import com.dao.AuthorUrlDao;

public class AuthorUrlEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("AuthorUrl edit servlet started");
		System.out.println(id);
		AuthorUrlBean authorUrl = new AuthorUrlDao().getAuthorUrlByPK(id);
		
		if(authorUrl!=null){
			System.out.println("if block");
			request.setAttribute("authorUrl",authorUrl);
			request.getRequestDispatcher("authorUrlEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in authorUrl edit servlet");
		}
	}

}
