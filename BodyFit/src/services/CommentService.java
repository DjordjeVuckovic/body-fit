package services;

import javax.ws.rs.Path;
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
import java.io.File;
import java.util.ArrayList;

import beans.Admin;
import beans.Comment;
import beans.Customer;
import beans.RandomGenerator;
import beans.Trainer;
import beans.Training;
import beans.User;
import dao.AdminDao;
import dao.CommentDao;
import dto.UserDto;


@Path("comments")
public class CommentService {

	CommentDao commentDao = new CommentDao();

	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if(ctx.getAttribute("comments")== null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("comments", new AdminService());
		}
	}
	
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	
	@POST
	@Path("/getAllByFacility")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Comment> getAllByFacility(String facilityId){
		commentDao.setBasePath(getContext());
		return commentDao.getAllByFacility(facilityId);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Comment> getAllComments() {
		commentDao.setBasePath(getContext());
		return commentDao.getAllToList();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Comment editCustomerById(Comment comment) {
		commentDao.setBasePath(getContext());
		Comment a = commentDao.getById(comment.getId());
		a.setState(comment.getState());;
		commentDao.update(a);
		return a;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment createComment(Comment comment) {
		commentDao.setBasePath(getContext());
		comment.setId(RandomGenerator.usingRandomUUID());
		commentDao.create(comment);
		return comment;
	}
}
