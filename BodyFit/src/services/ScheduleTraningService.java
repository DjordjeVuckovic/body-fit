package services;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Customer;
import beans.ScheduleTraning;
import beans.SportFacility;
import beans.Training;
import dao.CustomerDao;
import dao.ManagerDao;
import dao.ScheduleTrainingDao;
import dao.SportFacilityDao;
import dao.TrainingDao;
import dto.ScheduleTraningDto;

@Path("scheduleTrainings")
public class ScheduleTraningService {
	TrainingDao trainingDao = new TrainingDao();
	ScheduleTrainingDao scheduleTrainingDao = new ScheduleTrainingDao();
	ManagerDao managerDao = new ManagerDao();
	CustomerDao customerDao = new CustomerDao();
	SportFacilityDao facilityDao = new SportFacilityDao();
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
	@POST
	@Path("/getAllPassedCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ScheduleTraningDto> getAllPassedCustomer(String id){
		scheduleTrainingDao.setBasePath(getContext());
		trainingDao.setBasePath(getContext());
		facilityDao.setBasePath(getContext());
		ArrayList<ScheduleTraningDto> scheduleTraningDtos = new ArrayList<ScheduleTraningDto>();
		for(ScheduleTraning training: scheduleTrainingDao.getAllPassedCustomer(id)) {
			Training tr = trainingDao.getById(training.getTraningId());
			SportFacility facility = facilityDao.getById(tr.getSportFacilityId());
			scheduleTraningDtos.add(new ScheduleTraningDto(training.getDateAssign(),training.getDateTraining(),training.getTraningId(),training.getCustomerId(),FormatDate(training.getStartTime()),FormatDate(training.getFinishTime()),training.getId(),training.isStatus(),tr,facility));
		}
		return scheduleTraningDtos;
	}
	@POST
	@Path("/getAllPassedTrainer")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ScheduleTraningDto> getAllPassedManager(String id){
		scheduleTrainingDao.setBasePath(getContext());
		trainingDao.setBasePath(getContext());
		facilityDao.setBasePath(getContext());
		ArrayList<ScheduleTraningDto> scheduleTraningDtos = new ArrayList<ScheduleTraningDto>();
		for(ScheduleTraning training: AllPassedTrainer(id)) {
			Training tr = trainingDao.getById(training.getTraningId());
			SportFacility facility = facilityDao.getById(tr.getSportFacilityId());
			scheduleTraningDtos.add(new ScheduleTraningDto(training.getDateAssign(),training.getDateTraining(),training.getTraningId(),training.getCustomerId(),FormatDate(training.getStartTime()),FormatDate(training.getFinishTime()),training.getId(),training.isStatus(),tr,facility));
		}
		return scheduleTraningDtos;
	}
	@POST
	@Path("/getAllUpcomingCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ScheduleTraningDto> getAllUpcomingCustomer(String id){
		scheduleTrainingDao.setBasePath(getContext());
		trainingDao.setBasePath(getContext());
		facilityDao.setBasePath(getContext());
		ArrayList<ScheduleTraningDto> scheduleTraningDtos = new ArrayList<ScheduleTraningDto>();
		for(ScheduleTraning training: scheduleTrainingDao.getAllUpcomingCustomer(id)) {
			Training tr = trainingDao.getById(training.getTraningId());
			SportFacility facility = facilityDao.getById(tr.getSportFacilityId());
			scheduleTraningDtos.add(new ScheduleTraningDto(training.getDateAssign(),training.getDateTraining(),training.getTraningId(),training.getCustomerId(),FormatDate(training.getStartTime()),FormatDate(training.getFinishTime()),training.getId(),training.isStatus(),tr,facility));
		}
		return scheduleTraningDtos;
	}
	@POST
	@Path("/getAllUpcomingTrainer")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ScheduleTraningDto> getAllUpcomingTrainer(String id){
		scheduleTrainingDao.setBasePath(getContext());
		trainingDao.setBasePath(getContext());
		facilityDao.setBasePath(getContext());
		ArrayList<ScheduleTraningDto> scheduleTraningDtos = new ArrayList<ScheduleTraningDto>();
		for(ScheduleTraning training: AllUpcomingTrainer(id)) {
			Training tr = trainingDao.getById(training.getTraningId());
			SportFacility facility = facilityDao.getById(tr.getSportFacilityId());
			scheduleTraningDtos.add(new ScheduleTraningDto(training.getDateAssign(),training.getDateTraining(),training.getTraningId(),training.getCustomerId(),FormatDate(training.getStartTime()),FormatDate(training.getFinishTime()),training.getId(),training.isStatus(),tr,facility));
		}
		return scheduleTraningDtos;
	}
	@POST
	@Path("/getAllByFacility")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ScheduleTraningDto> getAllByFacility(String id){
		scheduleTrainingDao.setBasePath(getContext());
		ArrayList<ScheduleTraningDto> scheduleTraningDtos = new ArrayList<ScheduleTraningDto>();
		for(ScheduleTraning scheduleTraning: getAllByManager(id)) {
			scheduleTraningDtos.add(new ScheduleTraningDto(scheduleTraning));
		}
		return scheduleTraningDtos;
	}
	@POST
	@Path("/getAllCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Customer> getAllCustomersForManager(String id){
		return getAllVisited(id);
	}
	@PUT
	@Path("/changeStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ChangeStatus(ScheduleTraningDto updateTraning) {
		scheduleTrainingDao.setBasePath(getContext());
		ScheduleTraning tr = scheduleTrainingDao.getById(updateTraning.id);
		tr.setStatus(true);
		scheduleTrainingDao.update(tr);
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
	private  ArrayList<ScheduleTraning> AllUpcomingTrainer(String trainerId){
		Date date = new Date();
		trainingDao.setBasePath(getContext());
		scheduleTrainingDao.setBasePath(getContext());
		ArrayList<ScheduleTraning> allTranings =  new ArrayList<ScheduleTraning>();
		for(ScheduleTraning scheduleTraning:scheduleTrainingDao.getAllAvailable()) {
			Training tr = trainingDao.getById(scheduleTraning.getTraningId());
			if(trainerId.equals(tr.getTrainerId())) {
			if(scheduleTraning.getDateTraining().compareTo(date) >= 0) {
				allTranings.add(scheduleTraning);
			}
			}
		}
		return allTranings;
	}
	private  ArrayList<ScheduleTraning> AllPassedTrainer(String trainerId ){
		Date date = new Date();
		trainingDao.setBasePath(getContext());
		scheduleTrainingDao.setBasePath(getContext());
		Date d = Date.from(LocalDate.now().minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		ArrayList<ScheduleTraning> allTranings =  new ArrayList<ScheduleTraning>();
		for(ScheduleTraning scheduleTraning:scheduleTrainingDao.getAllAvailable()) {
			Training tr = trainingDao.getById(scheduleTraning.getTraningId());
			if(trainerId.equals(tr.getTrainerId())) {
				if(scheduleTraning.getDateTraining().compareTo(date) < 0) {
					if(scheduleTraning.getDateTraining().compareTo(d) > 0) {
						allTranings.add(scheduleTraning);
				}
			}
			}
		}
		return allTranings;
	}
	private ArrayList<ScheduleTraning> getAllByManager(String facilityId){
		trainingDao.setBasePath(getContext());
		scheduleTrainingDao.setBasePath(getContext());
		managerDao.setBasePath(getContext());
		ArrayList<ScheduleTraning> allTranings =  new ArrayList<ScheduleTraning>();
		for(ScheduleTraning scheduleTraning:scheduleTrainingDao.getAllAvailable()) {
			Training tr = trainingDao.getById(scheduleTraning.getTraningId());
			if(facilityId.equals(tr.getSportFacilityId())) {
				allTranings.add(scheduleTraning);
			}
		}
		return allTranings;
	}
	private Collection<Customer> getAllVisited(String facilityId){
		trainingDao.setBasePath(getContext());
		scheduleTrainingDao.setBasePath(getContext());
		managerDao.setBasePath(getContext());
		customerDao.setBasePath(getContext());
		HashMap<String,Customer> allCustomers =  new HashMap<String,Customer>();
		for(ScheduleTraning scheduleTraning:scheduleTrainingDao.getAllToList()) {
			Training tr = trainingDao.getById(scheduleTraning.getTraningId());
			if(facilityId.equals(tr.getSportFacilityId())) {
				Customer c = customerDao.getById(scheduleTraning.getCustomerId());
				allCustomers.put(c.getUsername(),c);
			}
		}
		return allCustomers.values();
	}
	private String FormatDate(LocalTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
		String timeString = time.format(formatter);
		return timeString;
	}
	
}
