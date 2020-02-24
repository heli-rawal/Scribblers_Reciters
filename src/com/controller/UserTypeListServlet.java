package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.UserTypeBean;
import com.dao.UserTypeDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class UserTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UserTypeBean> userTypeList = new UserTypeDao().select();
		
		if(userTypeList!=null){
			
			
			request.setAttribute("userTypeList", userTypeList);	
			request.getRequestDispatcher("userTypeList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}