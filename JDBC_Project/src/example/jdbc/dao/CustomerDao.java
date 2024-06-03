package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.cj.jdbc.JdbcConnection;

import example.jdbc.entity.Customer;
import example.jdbc.util.JdbcUtils;

public class CustomerDao implements DaoInterface<Customer, Integer> {

	@Override
	public Collection<Customer> retriveAll() {
		// creating an empty collection of customers
		Collection<Customer> allCustomers = new ArrayList<>();

		String sqlQuery = " select cname,address,custid from customer1";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)) {
			while (rs.next()) {

				String name = rs.getString(1);
				String Address = rs.getString(2);
				int id = rs.getInt(3);
				Customer currentCustomer = new Customer(id, name, Address);
				allCustomers.add(currentCustomer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allCustomers;
	}

	@Override
	public Customer retrieveOne(Integer id) {
		// featching single agent id and returning it
		Customer foundCustomer = null;
		String sqlQuery = "select cname,address,custid from customer1 where custid=?";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())// customer exist
			{
				String name = rs.getString(1);
				String Address = rs.getString(2);
				int custid = rs.getInt(3);
				foundCustomer = new Customer(custid, name, Address);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundCustomer;
	}

	@Override
	public void create(Customer customerRef) {
		String sqlQuery = "insert into customer1 values(?,?,?)";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)) {
			// retriving data from customerref
			int custid = customerRef.getCustomerId();
			String custname = customerRef.getName();
			String custaddress = customerRef.getAddress();
			// seting data in place of unknown parameter
			pstmt.setInt(1, custid);
			pstmt.setString(2, custname);
			pstmt.setString(3, custaddress);
			int updatecount = pstmt.executeUpdate();
			System.out.println(updatecount + "record inserted");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void Delete(Integer id) {
		String sqlQuery = "delete from customer1 where custid=?";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery))
		{
			pstmt.setInt(1, id);
			int updateCount =pstmt.executeUpdate();
			if(updateCount!=0)
			System.out.println(updateCount +"delete record");
			else
				System.out.println("record not found");
			

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
