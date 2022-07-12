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

import beans.FacilityContent;
import dao.FacilityContentDao;

@Path("contents")
public class FacilityContentService {
	FacilityContentDao contentDao = new FacilityContentDao();
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("newTraining") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("newTraining", new FacilityContent());
		}
	}
	private String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@POST
	@Path("/")	
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTraining(FacilityContent content) {
		//sportFacilityDao.setBasePath(getContext());
		contentDao.setBasePath(getContext());
		contentDao.create(content);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FacilityContent> getAll(){
		contentDao.setBasePath(getContext());
		return contentDao.getAllToList();
	}
	@POST
	@Path("/getByFacility")	
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FacilityContent> getByFacility(String id) {
		//sportFacilityDao.setBasePath(getContext());
		contentDao.setBasePath(getContext());
		return contentDao.getAllByFacility(id);
	}

}
