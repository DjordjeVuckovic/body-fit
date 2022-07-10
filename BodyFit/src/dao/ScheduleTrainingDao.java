package dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import beans.ScheduleTraning;
import beans.SportFacility;
import beans.Training;

public class ScheduleTrainingDao  extends GenericDao<String, ScheduleTraning, ScheduleTrainingDao> {
	@Override
	protected String getKey(ScheduleTraning entity) {
		// TODO Auto-generated method stub
		return entity.getId();
	}

	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "scheduleTraning.json";
	}
	public Map<String,ScheduleTraning> getAllToMap(){
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(getPath())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Type empMapType = new TypeToken<Map<String, ScheduleTraning>>() {
		}.getType();

		Map<String, ScheduleTraning> map = gs.fromJson(json, empMapType);
		return map;
		
	}

	@Override
	public ArrayList<ScheduleTraning> getAllToList() {
		// TODO Auto-generated method stub
		return new ArrayList<ScheduleTraning>(getAllToMap().values());
	}
	public ArrayList<ScheduleTraning> getAllAvailable() {
		// TODO Auto-generated method stub
		ArrayList<ScheduleTraning> allTranings =  new ArrayList<ScheduleTraning>();
		for(ScheduleTraning sh : getAllToMap().values()) {
			if(!sh.isStatus()) {
				allTranings.add(sh);
			}
		}
		return allTranings;
	}
	public  ArrayList<ScheduleTraning> getAllPassedCustomer(String customerId){
		Date date = new Date();
		Date d = Date.from(LocalDate.now().minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		ArrayList<ScheduleTraning> allTranings =  new ArrayList<ScheduleTraning>();
		for(ScheduleTraning scheduleTraning:getAllAvailable()) {
			if(scheduleTraning.getCustomerId().equals(customerId)) {
			if(scheduleTraning.getDateTraining().compareTo(date) < 0) {
				if(scheduleTraning.getDateTraining().compareTo(d) > 0) {
				allTranings.add(scheduleTraning);
				}
			}
			}
		}
		return allTranings;
	}
	public  ArrayList<ScheduleTraning> getAllUpcomingCustomer(String customerId){
		Date date = new Date();
		ArrayList<ScheduleTraning> allTranings =  new ArrayList<ScheduleTraning>();
		for(ScheduleTraning scheduleTraning:getAllAvailable()) {
			if(scheduleTraning.getCustomerId().equals(customerId)) {
			if(scheduleTraning.getDateTraining().compareTo(date) >= 0) {
				allTranings.add(scheduleTraning);
			}
			}
		}
		return allTranings;
	}

}
