package com.sgi.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConn {
	
	private Connection conn=null;
	private String url="jdbc:mysql://localhost:3306/sgi";
	private String user="root";
	private String pass="";
	
	public Connection config(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,pass);
			
			System.out.println("Connection Successfully...!!!!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
}
