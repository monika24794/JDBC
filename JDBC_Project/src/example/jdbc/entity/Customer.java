package example.jdbc.entity;

public class Customer {
	private int customerId;
	private String name;
	private String Address;
	
	public Customer()
	{
		
	}

	public Customer(int customerId, String name, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		Address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", Address=" + Address + "]";
	}
	
}
