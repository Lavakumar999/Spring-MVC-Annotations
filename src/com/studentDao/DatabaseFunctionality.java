package com.studentDao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseFunctionality {
	public Connection database() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","root","");
	return con;
	}  
}
