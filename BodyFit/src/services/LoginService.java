package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

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
@Provider
@PreMatching
public class LoginService implements ContainerResponseFilter,ContainerRequestFilter  {
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
	@POST
	@Path("logInStatus")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean SuccesLoginIn(User user) {
		UserState loginState = customerLogIn(user);
		boolean loginStatus= false;
		if(loginState == UserState.SUCCESS) {
			loginStatus =  true;
		}
		loginState = adminLogIn(user);
		if(loginState == UserState.SUCCESS) {
			loginStatus = true;
		}
		loginState = managerLogIn(user);
		if(loginState == UserState.SUCCESS) {
			loginStatus =  true;
		}
		loginState = trainerLogIn(user);
		if(loginState == UserState.SUCCESS) {
			loginStatus = true;
		}
		return loginStatus;
		
	}
	@GET
	@Path("loggedUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getCurrentUser() {
		adminDao.setBasePath(getContext());
		customerDao.setBasePath(getContext());
		managerDao.setBasePath(getContext());
		trainerDao.setBasePath(getContext());
		User user = new User();
		String username = (String) ctx.getAttribute("username");
		user.setUsername(username);
		User trainer = trainerDao.getById(username);
		if(trainer != null) {
			return trainer;
		}
		User manager = managerDao.getById(username);
		if(manager != null) {
			return manager;
		}
		User customer = customerDao.getById(username);
		if(customer != null) {
			return customer;
		}
		User admin = adminDao.getById(username);
		if(admin != null) {
			return admin;
		}
		return null;
		
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
	
	public String getCustomerStateString(User user) {
		UserState state  = customerLogIn(user);
		String userState = "";
		switch (state) {
		case SUCCESS:
			userState = "Success login";
			break;
		case ERROR:
			userState = "Wrong credential.Wrong username or password!";
			break;
		case BANNED:
			userState = "Your are banned!";
			break;

		default:
			break;
		}
		return userState;
	}
	public String getTrainerStateString(User user) {
		UserState state  = trainerLogIn(user);
		String userState = "";
		switch (state) {
		case SUCCESS:
			userState = "Success login";
			break;
		case ERROR:
			userState = "Wrong credential.Wrong username or password!";
			break;
		case BANNED:
			userState = "Your are banned!";
			break;

		default:
			break;
		}
		return userState;
	}
	public String getManagerStateString(User user) {
		UserState state  = managerLogIn(user);
		String userState = "";
		switch (state) {
		case SUCCESS:
			userState = "Success login";
			break;
		case ERROR:
			userState = "Wrong credential.Wrong username or password!";
			break;
		case BANNED:
			userState = "Your are banned!";
			break;

		default:
			break;
		}
		return userState;
	}
	public String getAdminStateString(User user) {
		UserState state  = adminLogIn(user);
		String userState = "";
		switch (state) {
		case SUCCESS:
			userState = "Success login";
			break;
		case ERROR:
			userState = "Wrong credential.Wrong username or password!";
			break;
		case BANNED:
			userState = "Your are banned!";
			break;

		default:
			break;
		}
		return userState;
	}	
	
	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		if (request.getHeaderString("Origin") == null) {
            return;
        }

        // If it is a preflight request, then we add all
        // the CORS headers here.
        if (isPreflightRequest(request)) {
            response.getHeaders().add("Access-Control-Allow-Credentials", "true");
            response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.getHeaders().add("Access-Control-Allow-Headers",
                // Whatever other non-standard/safe headers (see list above) 
                // you want the client to be able to send to the server,
                // put it in this list. And remove the ones you don't want.
                "X-Requested-With, Authorization, " +
                "Accept-Version, Content-MD5, CSRF-Token, Content-Type");
        }

        // Cross origin requests can be either simple requests
        // or preflight request. We need to add this header
        // to both type of requests. Only preflight requests
        // need the previously added headers.
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
    }
		
	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		// TODO Auto-generated method stub
		if (isPreflightRequest(request)) {
            request.abortWith(Response.ok().build());
            return;
        }
	}
	private static boolean isPreflightRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null
                && request.getMethod().equalsIgnoreCase("OPTIONS");
    }

}
