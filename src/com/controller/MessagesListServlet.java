
package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.MessagesBean;
import com.dao.MessagesDao;

/**
 * Servlet implementation class AdminListServlet
 */
public class MessagesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Messages list started");
		List<MessagesBean> messagesList = new MessagesDao().select();
		
		if(messagesList!=null){
			
			
			request.setAttribute("messagesList", messagesList);	
			request.getRequestDispatcher("messagesList.jsp").forward(request, response);
		}else{
			//TODO
			
		}
		
	
	
		
		
	}
}