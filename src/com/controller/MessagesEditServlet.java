package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MessagesBean;
import com.dao.MessagesDao;

public class MessagesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("Messages edit servlet started");
		System.out.println(id);
		MessagesBean messages= new MessagesDao().getMessagesByPK(id);
		
		if(messages!=null){
			System.out.println("if block");
			request.setAttribute("messages",messages);
			request.getRequestDispatcher("messagesEdit.jsp").forward(request, response);
		}else{
			System.out.println("error in messages edit servlet");
		}
	}

}
