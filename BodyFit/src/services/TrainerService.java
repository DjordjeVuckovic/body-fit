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

import beans.Manager;

import beans.Trainer;
import beans.User;
import beans.UserRole;
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
		return trainerDao.getAllToList();
	}
	@POST
	@Path("/create")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTrainer(Trainer trainer) {
		trainerDao.setBasePath(getContext());
		trainerDao.create(trainer);
	}
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Trainer createTrainer(UserDto newTrainer) {
		trainerDao.setBasePath(getContext());
		Trainer trainer = new Trainer(newTrainer.username,newTrainer.password,newTrainer.name,newTrainer.surname,newTrainer.birthday,newTrainer.gerGenderEnum(),UserRole.COACH);
		trainerDao.create(trainer);
		return trainer;
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
		t.setPassword(trainer.password);
		trainerDao.update(t);
		return t;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();
	}
	

}
