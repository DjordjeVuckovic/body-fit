package services;

import java.io.File;
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
import javax.ws.rs.core.Response;

import beans.Customer;
import beans.Manager;
import beans.User;
import dao.ManagerDao;
import dao.SportFacilityDao;
import dto.UserDto;
@Path("managers")
public class MangerService {
	ManagerDao managerDao = new ManagerDao();
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("managers") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("managers", new MangerService());
		}
	}
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editManager")
	public User editCustomerById(UserDto manager) {
		managerDao.setBasePath(getContext());
		Manager c = managerDao.getById(manager.username);
		c.setName(manager.name);
		c.setSurname(manager.surname);
		c.setPassword(manager.password);
		managerDao.update(c);
		return c;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Manager> getAllMangers() {
		managerDao.setBasePath(getContext());
		return managerDao.getAllToList();
	}
	@POST
	@Path("create")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createManger(Manager manager) {
		managerDao.setBasePath(getContext());
		managerDao.create(manager);
	}
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Manager createManager(UserDto manager) {
		managerDao.setBasePath(getContext());
		Manager maangerNew = new Manager(manager.username,manager.password,manager.name,manager.surname,manager.birthday,manager.gerGenderEnum(),null);
		managerDao.create(maangerNew);
		return maangerNew;
	}
	@GET
	@Path("/getAvailable")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Manager> getAllAvailableManagers() {
		managerDao.setBasePath(getContext());
		return managerDao.getAllAvailable();
	}
}
