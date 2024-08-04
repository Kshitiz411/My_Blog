package com.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.project.connector.ConnectionProvider;
import com.project.dao.UserDao;
import com.project.entities.User;

/**
 * Servlet implementation class RegisterServlet
 */


@MultipartConfig
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		String name= req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String password =req.getParameter("user_password");
		String gender = req.getParameter("gender");
		
		// create user object and set all data to that object
		
		User user = new User(name, email ,password, gender);
		
		//create a user dao object
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		
		if(dao.saveUser(user)) {
			
			printWriter.println("done");
			
		}else {
			printWriter.println("error");
		}
	}
	

}
