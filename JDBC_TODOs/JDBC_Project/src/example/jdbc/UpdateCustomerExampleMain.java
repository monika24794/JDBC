package example.jdbc;

import java.util.Scanner;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class UpdateCustomerExampleMain {
//	public static void main(String[] args) {
//		DaoInterface<Customer, Integer> daoref = new CustomerDao();
//		Customer customerref = daoref.retrieveOne(5);
//		customerref.setName("Monika ");
//		customerref.setAddress("Nashik");
//		daoref.update(customerref);
//	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter id to change");
		int id = in.nextInt();
		DaoInterface<Customer, Integer> daoref = new CustomerDao();
		Customer customerref = daoref.retrieveOne(id);
	

		System.out.println("enter 1.name  and 2.address 0.exit to change ");
		int ch = in.nextInt();
		switch (ch) {
		case 1:
			String name = in.next();
			customerref.setName(name);
			break;
		case 2:
			String add = in.next();
			customerref.setAddress(add);
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
		

		daoref.update(customerref);
	}

}
