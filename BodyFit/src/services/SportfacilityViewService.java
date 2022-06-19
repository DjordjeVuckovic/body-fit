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

import beans.Manager;
import dao.ManagerDao;
import dao.SportFacilityDao;
@Path("faciliesView")
public class SportfacilityViewService {
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("facility") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("facility", new String());
		}
	}
	

}
