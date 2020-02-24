package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.SecurityQuestionBean;
import com.dao.SecurityQuestionDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class SecurityQuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<SecurityQuestionBean> securityQuestionList = new SecurityQuestionDao().select();
		
		if(securityQuestionList!=null){
			
			
			request.setAttribute("securityQuestionList", securityQuestionList);	
			request.getRequestDispatcher("securityQuestionList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}