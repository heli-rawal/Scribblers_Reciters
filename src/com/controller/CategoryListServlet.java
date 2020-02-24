package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.CategoryBean;
import com.dao.CategoryDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<CategoryBean> categoryList= new CategoryDao().select();
		
		if(categoryList!=null){
			
			
			request.setAttribute("categoryList", categoryList);	
			request.getRequestDispatcher("categoryList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}