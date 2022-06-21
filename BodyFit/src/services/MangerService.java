package services;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Manager;
import beans.UserRole;
import dao.ManagerDao;
import dto.UserDto;
@Path("managers")
public class MangerService {
	ManagerDao managerDao = new ManagerDao();
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("managers") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("managers", new CustomerService());
		}
	}
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Manager> getAllManagers() {
		managerDao.setBasePath(getContext());
//
//		ArrayList<Customer> customers = new ArrayList<Customer>();
//
//		for (Customer c : customerDao.getAllToList())
//			customers.add(c);
//
//		System.out.println("Found " + customers.size() + " customers.");

		return managerDao.getAllToList();
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Manager> getAllAvailableManagers() {
		managerDao.setBasePath(getContext());
//
//		ArrayList<Customer> customers = new ArrayList<Customer>();
//
//		for (Customer c : customerDao.getAllToList())
//			customers.add(c);
//
//		System.out.println("Found " + customers.size() + " customers.");

		return managerDao.getAllAvailable();
	}
	@POST
	@Path("/")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createManger(UserDto manager) {
		managerDao.setBasePath(getContext());
		Manager newManger = new Manager(manager.username, manager.password, manager.name, manager.surname, manager.birthday, manager.gerGenderEnum(), UserRole.MANAGER, "");
		managerDao.create(newManger);
	}
}
