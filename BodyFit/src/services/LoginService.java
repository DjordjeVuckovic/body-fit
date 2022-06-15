package services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Admin;
import beans.Customer;
import beans.Manager;
import beans.Trainer;
import beans.User;
import dao.AdminDao;
import dao.CustomerDao;
import dao.ManagerDao;
import dao.TrainerDao;
@Path("login")
public class LoginService {
	CustomerDao customerDao = new CustomerDao();
	ManagerDao managerDao = new ManagerDao();
	AdminDao adminDao = new AdminDao();
	TrainerDao trainerDao = new TrainerDao();
	private User user;
	List<String> usernames;
	
	@Context
	ServletContext ctx;
	
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("username") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("username", "");
		}
	}
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	private void setLoggedInUser(String username) {
		ctx.setAttribute("username", username);
	}
	
	@POST
	@Path("logOut")
	@Produces(MediaType.TEXT_PLAIN)
	public String userLogOut() {
		ctx.setAttribute("username", "");
		return "Log Out Successful";
	}
	public UserState customerLogIn(User user) {
		UserState state = UserState.ERROR;
		customerDao.setBasePath(getContext());
		for (Customer u : customerDao.getAllToList()) {
			if (u.getUsername().equals(user.getUsername())) {
				if (u.getPassword().equals(user.getPassword())) {
					if(u.isBanned()) {
						state = UserState.BANNED;
					}
					else {
						setLoggedInUser(user.getUsername());
						state = UserState.SUCCESS;
					}
			}
		}
		}
		return state;
	}

	public UserState adminLogIn(User user) {
		adminDao.setBasePath(getContext());
		UserState state = UserState.ERROR;
		for (Admin u : adminDao.getAllToList()) {
			if (u.getUsername().equals(user.getUsername())) {
				if (u.getPassword().equals(user.getPassword())) {
					setLoggedInUser(user.getUsername());
					return UserState.SUCCESS;
			
			}
		}
		}
		return state;
	}

	public UserState managerLogIn(User user) {
		managerDao.setBasePath(getContext());
		UserState state = UserState.ERROR;
		for (Manager u : managerDao.getAllToList()) {
			if (u.getUsername().equals(user.getUsername())) {
				if (u.getPassword().equals(u.getPassword())) {
					if(u.isBanned()) {
						state =  UserState.BANNED;
					}
					else {
						setLoggedInUser(u.getUsername());
						state = UserState.SUCCESS;
					}
				}
			}
		}
		return state;
	}

	public UserState trainerLogIn(User user) {
		trainerDao.setBasePath(getContext());
		UserState state = UserState.ERROR;
		for (Trainer u : trainerDao.getAllToList()) {
			if (u.getUsername().equals(user.getUsername())) {
				if (u.getPassword().equals(user.getPassword())) {
					if(u.isBanned()) {
						state = UserState.BANNED;
					}
					else {
						setLoggedInUser(user.getUsername());
						state = UserState.SUCCESS;
					}
				}
			}
		}
		return state;
	}
	
	

}
