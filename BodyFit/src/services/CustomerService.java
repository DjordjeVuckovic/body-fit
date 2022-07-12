package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import beans.CustomerType;
import beans.Manager;
import beans.Membership;
import beans.User;
import dao.CustomerDao;
import dto.CustomerDto;
import dto.UserDto;
@Path("customers")
public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("customers") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("customers", new CustomerService());
		}
	}
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Customer> getAllCustomers() {
		customerDao.setBasePath(getContext());
		return customerDao.getAllToList();
	}
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Customer createCustomer(UserDto customer) {
		customerDao.setBasePath(getContext());
		Customer customerNew = new Customer(customer.username,customer.password,customer.name,customer.surname,customer.birthday,customer.gerGenderEnum(),null);
		customerDao.create(customerNew);
		return customerNew;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editCustomer")
	public User editCustomerById(UserDto customer) {
		customerDao.setBasePath(getContext());
		Customer c = customerDao.getById(customer.username);
		c.setName(customer.name);
		c.setSurname(customer.surname);
		c.setPassword(customer.password);
		customerDao.update(c);
		return c;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editCustomerPoints")
	public User editCustomerPoints(CustomerDto customer) {
		customerDao.setBasePath(getContext());
		Customer c = customerDao.getById(customer.username);
		c.setColletedPoints(customer.colletedPoints);
		c.setCustomerType(new CustomerType(customer.userType, customer.dicount, 0));
		customerDao.update(c);
		return c;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	
	

}