package example.jdbc;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class CreateNewCustomerExampleMain {
	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoref=new CustomerDao();
		Customer customerobj=new Customer(6, "shivanjali", "Baramati");
		daoref.create(customerobj);
	}

}
