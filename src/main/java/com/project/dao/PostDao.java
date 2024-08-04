  package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.project.entities.Category;
import com.project.entities.Post;

public class PostDao {
	
 Connection con;

public PostDao(Connection con) {
	super();
	this.con = con;
}
 
	public ArrayList<Category> getAllCategories(){
		ArrayList<Category> List=new ArrayList<>();
		
		try {
			String q="select * from categories";
			Statement st= this.con.createStatement();
			ResultSet set=st.executeQuery(q);
			
			while(set.next()) 
			{
				int cid = set.getInt("cid");
				String name=set.getString("name");
				String description=set.getString("description");
				Category c = new Category(cid,name,description);
				List.add(c);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return List;
		
	}
	
	public boolean savePost(Post p) {
		boolean f = false;
		try {
			String q = "insert into posts(pTittle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(q);
			pstmt.setString(1,p.getpTittle());
			pstmt.setString(2, p.getpContent());
			pstmt.setString(3, p.getpCode());
			pstmt.setString(4, p.getpPic());
			pstmt.setInt(5, p.getCatId());
			pstmt.setInt(6, p.getUserId());
			
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
		
	}
}
