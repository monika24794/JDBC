package example.jdbc;

import java.util.Collection;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class DaoEnhancementExampleMain {

	public static void main(String[] args) {
		EnhanceCustomerDAO  enhanceDaoref=new EnhanceCustomerDAO();
		Collection< Customer>
		cutomerwithmatchingcity=enhanceDaoref.retriveAllMatchingCustomerByCityName("Nagpur");
		int size=cutomerwithmatchingcity.size();
		if(size!=0)
		{
			for (Customer customerRef : cutomerwithmatchingcity) {
				System.out.println(customerRef);
			}
		}
		else {
			System.out.println("No customer found with the given city");
		}
		
	}

}
