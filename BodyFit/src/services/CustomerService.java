package services;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import dao.CustomerDao;
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
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "data"
				+ File.separator);
	}
	@GET
	@Path("getAllCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Customer> getAll() {
		customerDao.setBasePath(getContext());

		ArrayList<Customer> customers = new ArrayList<Customer>();

		for (Customer c : customerDao.getAllToList())
			customers.add(c);

		System.out.println("Found " + customers.size() + " customres.");

		return customers;
	}

}
