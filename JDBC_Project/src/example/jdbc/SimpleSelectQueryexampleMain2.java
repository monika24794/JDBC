package example.jdbc;
import java.util.Collection;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class SimpleSelectQueryexampleMain2
{
public static void main(String[] args) {

	DaoInterface<Customer, Integer> deoref=new CustomerDao();
	Collection<Customer>allCustomers=deoref.retriveAll();
	for(Customer cust : allCustomers)
	{
		System.out.println(cust);
	}
	
	
	
	
	
}
}
