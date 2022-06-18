package beans;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
	private ArrayList<String> visitedFacilities;
	private CustomerType customerType;
	private double colletedPoints;
	private Due due;
	

	
	public Customer(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole, double colletedPoints) {
		super(username, password, name, surname, birthdate, gender, userRole);
		this.colletedPoints = colletedPoints;
	}
	public Customer(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole,Due due) {
		super(username, password, name, surname, birthdate, gender, userRole);
		this.setUserRole(userRole);
		visitedFacilities = new ArrayList<String>();
		this.customerType = new CustomerType("BRONZE", 0, 0);
		this.colletedPoints = 0;
		this.due = due;

	}
	
	public Customer(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole) {
		super(username, password, name, surname, birthdate, gender, userRole);
		this.setUserRole(UserRole.CUSTOMER);
		this.colletedPoints = 0;
		visitedFacilities = new ArrayList<String>();
		this.customerType = new CustomerType("BRONZE", 0, 0);
	}
	
	public Customer() {
		super();
	}
	public ArrayList<String> getVisitedFacilities() {
		return visitedFacilities;
	}
	public void setVisitedFacilities(ArrayList<String> visitedFacilities) {
		this.visitedFacilities = visitedFacilities;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public double getColletedPoints() {
		return colletedPoints;
	}
	public void setColletedPoints(double colletedPoints) {
		this.colletedPoints = colletedPoints;
	}
	public Due getDue() {
		return due;
	}
	public void setDue(Due due) {
		this.due = due;
	}
	
	

}
