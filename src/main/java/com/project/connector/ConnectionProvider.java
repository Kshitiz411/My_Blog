package com.project.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider{
	
 public  static Connection con;
 public static Connection getConnection() {
	 
	 try {
		 if(con == null) {
		 
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 String url ="jdbc:mysql://localhost:3306/KshitizBlog";
		 String username="root";
		 String password="Kshitiz07@";
		 
		 con= DriverManager.getConnection(url, username, password);
		 
		 System.out.println("Connection is established !!!");
		 } 
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 
	 return con;
	 
 }
 
}
