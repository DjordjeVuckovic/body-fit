package dto;

import beans.Customer;
import beans.CustomerType;

public class CustomerDto {
	public String username;
	public double colletedPoints;
	public double dicount;
	public String userType;
	public CustomerDto(Customer customer) {
		super();
		this.username = customer.getUsername();
		this.colletedPoints = customer.getColletedPoints();
		this.dicount = customer.getCustomerType().getDicount();
		this.userType = customer.getCustomerType().getName();
	}
	public CustomerDto() {
		super();
	}

	
	
}
