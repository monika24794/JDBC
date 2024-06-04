package example.jdbc;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class RetriveOneCustomerExampleMain {
public static void main(String[] args) {
	DaoInterface<Customer, Integer> daoref=new CustomerDao();
	Customer customerRef=daoref.retrieveOne(5);
	if(customerRef!=null)
		System.out.println(customerRef);
	else
		System.out.println("Customer with given id is not aveliable");
}
}
