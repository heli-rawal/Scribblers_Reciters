package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UserBean> userList = new UserDao().select();
		
		if(userList!=null){
			
			
			request.setAttribute("userList", userList);	
			request.getRequestDispatcher("UserList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}