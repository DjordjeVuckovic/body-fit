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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import beans.Trainer;
import beans.User;
import dao.TrainerDao;
import dto.UserDto;

@Path("trainers")
public class TrainerService  {
	
	TrainerDao trainerDao = new TrainerDao();
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("trainers") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("trainers", new CustomerService());
		}
	}
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Trainer> getAllTrainers() {
		trainerDao.setBasePath(getContext());
//
//		ArrayList<Customer> customers = new ArrayList<Customer>();
//
//		for (Customer c : customerDao.getAllToList())
//			customers.add(c);
//
//		System.out.println("Found " + customers.size() + " customers.");

		return trainerDao.getAllToList();
	}
	@POST
	@Path("/")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTrainer(Trainer trainer) {
		trainerDao.setBasePath(getContext());
		trainerDao.create(trainer);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editTrainer")
	public User editCustomerById(UserDto trainer) {
		trainerDao.setBasePath(getContext());
		Trainer t = trainerDao.getById(trainer.username);
		t.setName(trainer.name);
		t.setSurname(trainer.surname);

		trainerDao.update(t);
		return t;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	

}
