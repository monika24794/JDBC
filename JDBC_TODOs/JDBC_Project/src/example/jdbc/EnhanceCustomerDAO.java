package example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.dao.CustomerDao;
import example.jdbc.entity.Customer;
import example.jdbc.util.JdbcUtils;

public class EnhanceCustomerDAO extends CustomerDao {

	public Collection<Customer> retriveAllMatchingCustomerByCityName(String cityName)
	{
		Collection<Customer> allMatchingCustomerCityName = new ArrayList<>();
		
	
		String sqlQuery = "select cname,address,custid from customer1 where address=?";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);) 
		{
			pstmt.setString(1, cityName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString(1);
				String Address = rs.getString(2);
				int id = rs.getInt(3);
				Customer currentCustomer = new Customer(id, name, Address);
				allMatchingCustomerCityName.add(currentCustomer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allMatchingCustomerCityName;
	}

}
