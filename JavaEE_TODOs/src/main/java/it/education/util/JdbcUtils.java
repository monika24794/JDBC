package it.education.util;

import java.sql.DriverManager;
import java.sql.Connection;
public class JdbcUtils 
{

public static Connection buildConnection()throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String URL="jdbc:mysql://localhost:3306/cdac";
	String UID="root";	
	String PWD="password";
	Connection dbconnection=DriverManager.getConnection(URL, UID, PWD);
	 return dbconnection;
}		
}
