package services;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import beans.Adress;
import beans.FacilityType;
import beans.Manager;
import beans.RandomGenerator;
import beans.SportFacility;
import dao.ManagerDao;
import dao.SportFacilityDao;
import dto.FacilityViewDto;
import dto.UserDto;

@Path("newFacilitie")
public class NewSportFacilityService {
	ManagerDao managerDao = new ManagerDao();
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	SportFacility sportFacility;
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("newFacilitie") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("newFacilitie", new SportFacility());
		}
	}
	private String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	private SportFacility getCurrentFacility() {
		return (SportFacility) ctx.getAttribute("newFacilitie");
	}
	private void setCurrentFacility(SportFacility facility) {
		ctx.setAttribute("newFacilitie",facility);
	}
	@POST
	@Path("/")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createFacility(FacilityViewDto sportFacility) {
		sportFacilityDao.setBasePath(getContext());
		SportFacility facility = new SportFacility(RandomGenerator.usingRandomUUID(), sportFacility.name, FacilityType.valueOf(sportFacility.type), new Adress(sportFacility.address, sportFacility.city, sportFacility.postal), 0);
		setCurrentFacility(facility);
		//sportFacilityDao.create(facility);
	}
	@POST
	@Path("setManager")	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void setManager(UserDto dto) {
		sportFacility = getCurrentFacility();
		sportFacilityDao.setBasePath(getContext());
		managerDao.setBasePath(getContext());
		Manager manager = managerDao.getById(dto.username);
		sportFacilityDao.create(sportFacility);
		manager.setSportFacilityId(sportFacility.getSportFacilityId());
		managerDao.update(manager);
	}

}

