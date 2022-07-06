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

import beans.SportFacility;
import beans.Trainer;
import beans.Training;
import beans.TrainingType;
import dao.ManagerDao;
import dao.SportFacilityDao;
import dao.TrainerDao;
import dao.TrainingDao;
import dto.TrainingDto;

@Path("trainings")
public class TrainingService {
	ManagerDao managerDao = new ManagerDao();
	SportFacilityDao sportFacilityDao = new SportFacilityDao();
	TrainingDao trainingDao = new TrainingDao();
	TrainerDao trainerDao = new TrainerDao();
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
	@POST
	@Path("/getAllByFacility")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Training> getAllByFacility(String facilityId){
		trainingDao.setBasePath(getContext());
		return trainingDao.getAllByFacility(facilityId);
	}
	@POST
	@Path("/getAllTrainers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Trainer> getAllTrainersForTrainings(String  managerFacilityId){
		trainerDao.setBasePath(getContext());
		Map<String, Trainer> trainersMap =  new HashMap<String, Trainer>();
		for(Training training: getAllByManager(managerFacilityId)) {
			if(!training.getTrainerId().isEmpty()) {
				Trainer trainer =  trainerDao.getById(training.getTrainerId());
				//System.out.println(trainer.getName());
				trainersMap.put(trainer.getUsername(), trainer);
			}
			
		}
		return trainersMap.values(); 
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Training getById(@PathParam("id") String id) {
		trainingDao.setBasePath(getContext());
		return trainingDao.getById(id);
	}
	@POST
	@Path("/getById")
	@Produces(MediaType.APPLICATION_JSON)
	public Training getByIdP(String id) {
		trainingDao.setBasePath(getContext());
		return trainingDao.getById(id);
	}
	@PUT
	@Path("/editTraining")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Training editTraining(TrainingDto newTraining) {
		trainingDao.setBasePath(getContext());
		Training trainingEdit = trainingDao.getById(newTraining.id);
		trainingEdit.setName(newTraining.name);
		trainingEdit.setType(TrainingType.valueOf(newTraining.type));
		trainingEdit.setDescription(newTraining.description);
		trainingEdit.setDuration(newTraining.duration);
		trainingEdit.setAdditionalPrice(newTraining.additionalPrice);
		trainingEdit.setTrainerId(newTraining.trainerId);
		trainingDao.update(trainingEdit);
		return trainingEdit;
	}
}
