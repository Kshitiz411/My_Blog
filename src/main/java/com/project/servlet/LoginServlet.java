package com.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


import com.project.connector.ConnectionProvider;
import com.project.dao.UserDao;
import com.project.entities.Message;
import com.project.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//fetch email and password from request
		PrintWriter printWriter =resp.getWriter();
		String userEmail= req.getParameter("email");
		String userPassword= req.getParameter("password");
		
		
		UserDao dao1 = new UserDao(ConnectionProvider.getConnection());
		
	User u =dao1.getUserByEmailAndPassword(userEmail, userPassword);
	
	if(u==null)
	{
		//login.....error
		//printWriter.println("Invalid Details....try again");
		Message message = new Message("wrong input! please try again","error", "alert-danger");
		HttpSession session=req.getSession();
		session.setAttribute("message",message);
		resp.sendRedirect("Login.jsp");
		
	}else {
		
		///login successs
	
	HttpSession session = req.getSession();
 session.setAttribute("currentUser", u);
	resp.sendRedirect("Profile.jsp");
	
	}
	

     }
}