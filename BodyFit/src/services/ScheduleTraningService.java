package services;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.ScheduleTraning;
import beans.SportFacility;
import beans.Trainer;
import beans.Training;
import beans.TrainingType;
import dao.ManagerDao;
import dao.ScheduleTrainingDao;
import dao.SportFacilityDao;
import dao.TrainerDao;
import dao.TrainingDao;
import dto.ScheduleTraningDto;
import dto.TrainingDto;

@Path("scheduleTrainings")
public class ScheduleTraningService {
	TrainingDao trainingDao = new TrainingDao();
	ScheduleTrainingDao scheduleTrainingDao = new ScheduleTrainingDao();
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("newTraining") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("newTraining", new ScheduleTraning());
		}
	}
	private String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ScheduleTraning createTraining(ScheduleTraningDto scheduleNew) {
		//sportFacilityDao.setBasePath(getContext());
		scheduleTrainingDao.setBasePath(getContext());
		ScheduleTraning scheduleTraning = new ScheduleTraning(scheduleNew.dateAssign,scheduleNew.dateTraining,scheduleNew.traningId,scheduleNew.customerId,GenerateId(),scheduleNew.parseTimeS(),scheduleNew.parseTimeF());
		scheduleTrainingDao.create(scheduleTraning);
		return scheduleTraning;
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ScheduleTraning> getAll(){
		scheduleTrainingDao.setBasePath(getContext());
		return scheduleTrainingDao.getAllToList();
	}
	
	private String GenerateId() {
		Integer maxId = -1;
		for (String id : scheduleTrainingDao.getAllToMap().keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		return maxId.toString();
	}
}
