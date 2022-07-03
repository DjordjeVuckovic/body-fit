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
import javax.ws.rs.core.Response;

import beans.SportFacility;
import beans.Training;
import beans.TrainingType;
import dao.ManagerDao;
import dao.SportFacilityDao;
import dao.TrainingDao;
import dto.TrainingDto;

@Path("trainings")
public class TrainingService {
	ManagerDao managerDao = new ManagerDao();
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	TrainingDao trainingDao = new TrainingDao();
	SportFacility sportFacility;
	@Context
	ServletContext ctx;
	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("newTraining") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("newTraining", new Training());
		}
	}
	private String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "jsonData"
				+ File.separator);
	}
	private Training getCurrenTraining() {
		return (Training) ctx.getAttribute("newTraining");
	}
	private void setCurrenTraining(Training training) {
		ctx.setAttribute("newTraining",training);
	}
	@POST
	@Path("/")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Training createTraining(TrainingDto newTraining) {
		//sportFacilityDao.setBasePath(getContext());
		trainingDao.setBasePath(getContext());
		Training training = new Training(GenerateId(), TrainingType.valueOf(newTraining.type),newTraining.sportFacilityId , newTraining.trainerId , newTraining.name, newTraining.description, newTraining.duration, newTraining.additionalPrice, false);
		setCurrenTraining(training);
		trainingDao.create(training);
		return training;
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Training> getAll(){
		trainingDao.setBasePath(getContext());
		return trainingDao.getAllToList();
	}
	private String GenerateId() {
		Integer maxId = -1;
		for (String id : trainingDao.getAllToMap().keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		return maxId.toString();
	}
	@POST
	@Path("/getAllByManager")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Training> getAllByManager(String managerFacilityId){
		trainingDao.setBasePath(getContext());
		return trainingDao.getAllByManager(managerFacilityId);
	} 
}
