package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.entities.User;

public class UserDao {
	
	
	public Connection con;

	public UserDao(Connection connector) {
		
		this.con = connector;
	}
	
	// method to insert user to database
	
    public boolean saveUser(User user) {
    
    	boolean d= false;
    	
    	try {
    		
    		// user--database
    		String query1 = "insert into blog(name, email,password,gender) values(?,?,?,?);";
    		PreparedStatement pstmt =con.prepareStatement(query1);
    		pstmt.setString(1,user.getNameString());
    		pstmt.setString(2, user.getEmail());
    		pstmt.setString(3, user.getPassword());
    		pstmt.setString(4, user.getGender());
    		
    	    pstmt.executeUpdate();
    		d=true;
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return d;
    	
    }
    
    // get user by email and userpassword:
    public User getUserByEmailAndPassword(String email,String password) {
    	
    	User user3 = null;
    	try {
    		
    	String query = "select * from blog where email=? and password=?";
    	PreparedStatement pstmt =con.prepareStatement(query);
    	pstmt.setString(1, email);
    	pstmt.setString(2, password);
    	
    	 ResultSet set=pstmt.executeQuery();
    	 
    	 if(set.next()) 
    	 {
    		user3= new User(); 
    		 //data from db
    		 String name=set.getString("name");
    		 //set to user object
    		 user3.setNameString(name);
    		 
    		 user3.setId(set.getInt("id"));
    		 user3.setEmail(set.getString("email"));
    		 user3.setPassword(set.getString("password"));
    		 user3.setGender(set.getString("gender"));
    		 user3.setDateTimestamp(set.getTimestamp("rdate"));
    		 user3.setProfile(set.getString("profile"));
    	 }
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    
    return user3;
}
    public boolean updateUser(User user) {
    	
    	boolean f=false;
    	try {
    	 
    		String query = "update blog  set name=?, email=?, password=?, gender=?,profile=? where id=?";
    		PreparedStatement p =con.prepareStatement(query);
    		p.setString(1,user.getNameString());
    		p.setString(2, user.getEmail());
    		p.setString(3, user.getPassword());
    		p.setString(4, user.getGender());
    		p.setString(5, user.getProfile());
    		p.setInt(6, user.getId());
    		

    		p.executeUpdate();
    		f=true;
    		
    }catch(Exception e) {
    	e.printStackTrace();
    }
    	return f;
}
}