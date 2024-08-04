package com.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;

import com.project.connector.ConnectionProvider;
import com.project.dao.PostDao;
import com.project.entities.Post;
import com.project.entities.User;

/**
 * Servlet implementation class PostServlet
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter printWriter =resp.getWriter();
		int cid=Integer.parseInt(req.getParameter("cid"));
		String pTitle=req.getParameter("pTitle");
		String pContent=req.getParameter("pContent");
		String pCode=req.getParameter("pCode");
		Part part=req.getPart("pic");
		// getting currentUser id
		HttpSession session = req.getSession();
		
		User user= (User)session.getAttribute("currentUser"); 
		
		
		
		printWriter.println("your post title is" +pTitle);
		printWriter.println(part.getSubmittedFileName());
		
		Post p = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid,user.getId());
		PostDao  dao= new PostDao(ConnectionProvider.getConnection());
		if(dao.savePost(p)) 
		{
			printWriter.println("done");
		}else
		{
			printWriter.println("error");
		}
	}
	
	
}
