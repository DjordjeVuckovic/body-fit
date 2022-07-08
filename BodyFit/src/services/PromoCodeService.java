package services;

import java.io.File;
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

import beans.Admin;
import beans.Customer;
import beans.PromoCode;
import beans.User;
import dao.PromoCodeDao;
import dto.UserDto;

@Path("promoCodes")
public class PromoCodeService {
	PromoCodeDao promoCodeDao = new PromoCodeDao();
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if(ctx.getAttribute("promoCodes")== null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("promoCodes", new PromoCodeService());
		}
	}
	
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PromoCode> getAllAdmins() {
		promoCodeDao.setBasePath(getContext());
		return promoCodeDao.getAllToList();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public PromoCode editCustomerById(PromoCode code) {
		promoCodeDao.setBasePath(getContext());
		PromoCode promoCode = promoCodeDao.getById(code.getCode());
		int quantity = promoCode.getQuantity()-1;
		promoCode.setQuantity(quantity);		
		promoCodeDao.update(promoCode);
		return promoCode;
	   //return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PromoCode createCustomer(PromoCode promoCode) {
		promoCodeDao.setBasePath(getContext());
		promoCodeDao.create(promoCode);
		return promoCode;
	}

}