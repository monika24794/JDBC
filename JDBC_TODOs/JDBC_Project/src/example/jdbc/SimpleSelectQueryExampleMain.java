package example.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSelectQueryExampleMain
{
public static void main(String[] args) {
	Connection dbconnection=null;
	Statement stmt=null;
	ResultSet rs =null;
	
	try {
		//1.load the driver
		String driverClassName="com.mysql.cj.jdbc.Driver";
		//load the driverfrom mysqlpackege
		Class.forName(driverClassName);
		//for name method fetch exception forname()->throw->classnotfound Exception
		System.out.println("Driver loaded");
		//2.establish connection
		String URL="jdbc:mysql://localhost:3306/cdac";
		String UID="root";	
		String PWD="password";
		 dbconnection=DriverManager.getConnection(URL, UID, PWD);
		System.out.println("connected");
		//3. obtain some statement
		 stmt=dbconnection.createStatement();
		//4.execute sql quary
		String sqlQuery=" select cname,address,custid from customer1";
		 rs = stmt.executeQuery(sqlQuery);
		 //5.3perform navigatoin because we used select query
		 
		 while (rs.next()) {
		
			String name=rs.getString(1);
			String Address=rs.getString(2);
			 int id=rs.getInt(3);
			 System.out.println("ID : " +id+"  Name : "+name+  "       Address : "+Address);
		} 
		 
		 
	}
	catch (ClassNotFoundException | SQLException e)
	{
		// TODO: handle exception
		e.printStackTrace();
	}
 
 finally {
	//closing all resoures
	 try {
		rs.close();
		stmt.close();
		dbconnection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
}
