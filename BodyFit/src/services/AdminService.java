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

import beans.Admin;
import beans.Customer;
import beans.Trainer;
import beans.User;
import dao.AdminDao;
import dto.UserDto;

@Path("admins")
public class AdminService{
	AdminDao adminDao = new AdminDao();

	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if(ctx.getAttribute("admins")== null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("admins", new AdminService());
		}
	}
	
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Admin> getAllAdmins() {
		adminDao.setBasePath(getContext());
		return adminDao.getAllToList();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editAdmin")
	public User editCustomerById(UserDto admin) {
		adminDao.setBasePath(getContext());
		Admin a = adminDao.getById(admin.username);
		a.setName(admin.name);
		a.setSurname(admin.surname);
		a.setPassword(admin.password);
		adminDao.update(a);
		return a;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
}
