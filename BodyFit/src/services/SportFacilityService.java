package services;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.SportFacility;
import dao.SportFacilityDao;
import dto.FacilityViewDto;

@Path("facilities")
public class SportFacilityService  {
	
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("facilities") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("facilities", new SportFacilityDao());
		}
	}
	public String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SportFacility> getAllFacilities() {
		sportFacilityDao.setBasePath(getContext());
		return sportFacilityDao.getAllToList();
	}
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FacilityViewDto> getAllFacilitiesDto() {
		sportFacilityDao.setBasePath(getContext());
		ArrayList<FacilityViewDto> facilityViewDtos = new ArrayList<FacilityViewDto>();
		for (SportFacility s : sportFacilityDao.getAllToList()) {
			facilityViewDtos.add(new FacilityViewDto(s));
		}
		return facilityViewDtos;
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteFacility(@PathParam("id") String id) {
		sportFacilityDao.setBasePath(getContext());
		sportFacilityDao.delete(id);
		
	}
	@POST
	@Path("/getById")
	@Produces(MediaType.APPLICATION_JSON)
	public SportFacility getById(String id) {
		sportFacilityDao.setBasePath(getContext());
		return sportFacilityDao.getById(id);
	}
	
	@POST
	@Path("/getByName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SportFacility getByName(String name) {
		sportFacilityDao.setBasePath(getContext());
		return sportFacilityDao.getByName(name);
	}
	


}
