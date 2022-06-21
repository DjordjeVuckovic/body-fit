package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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

import beans.Adress;
import beans.FacilityType;
import beans.RandomGenerator;
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
			ctx.setAttribute("facilities", new SportFacilityService());
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
	
	

}
