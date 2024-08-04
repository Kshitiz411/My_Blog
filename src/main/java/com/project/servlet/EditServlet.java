package com.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.project.connector.ConnectionProvider;
import com.project.connector.Helper;
import com.project.dao.UserDao;
import com.project.entities.Message;
import com.project.entities.User;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetch all data
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		String userEmail=req.getParameter("user_email");
		String userName = req.getParameter("user_name");
		String userPassword = req.getParameter("user_password");
		Part part = req.getPart("image");
		String imageName=part.getSubmittedFileName();
		
		// get the user from the session
		HttpSession s= req.getSession();
	User user =(User)s.getAttribute("currentUser");
	
		user.setEmail(userEmail);
		user.setNameString(userName);
		user.setPassword(userPassword);
		String oldFile = user.getProfile();
		user.setProfile(imageName);
		
		
		//update database
		UserDao userDao= new UserDao(ConnectionProvider.getConnection());
		
		boolean ans=userDao.updateUser(user);
		
		if(ans) {
			String path=req.getServletContext().getRealPath("/")+"pics"+File.separator+user.getProfile();
			
			String pathOldFile=req.getServletContext().getRealPath("/")+"pics"+File.separator+oldFile;
			if(!oldFile.equals("default.png")) {
				
			Helper.deleteFile(pathOldFile);
			}
			
				if(Helper.saveFile(part.getInputStream(), path));{
			
			printWriter.println("Profile updated.....");
			
			Message message = new Message("Profile details updated....","success", "alert-success");
			
			s.setAttribute("message",message);	
				
					
		}
			
			
			
		}else {
			printWriter.println("not updated..");
			Message message = new Message("Something went wrong  !!","error", "alert-danger");
		
			s.setAttribute("message",message);
		}
		
		resp.sendRedirect("profile.jsp");
		
	}
	
}

