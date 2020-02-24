package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RatingBean;
import com.dao.RatingDao;

public class RatingEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("Rating edit servlet started");
		System.out.println(id);
		RatingBean rating = new RatingDao().getRatingByPK(id);
		
		if(rating!=null){
			System.out.println("if block");
			request.setAttribute("rating",rating);
			request.getRequestDispatcher("ratingEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in rating edit servlet");
		}
	}

}
