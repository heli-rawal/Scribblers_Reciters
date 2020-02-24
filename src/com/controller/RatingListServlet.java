package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.RatingBean;
import com.dao.RatingDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class RatingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rating list started");
		List<RatingBean> ratingList = new RatingDao().select();
		
		if(ratingList!=null){
			
			
			request.setAttribute("ratingList", ratingList);	
			request.getRequestDispatcher("ratingList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}