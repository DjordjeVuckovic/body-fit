package dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import beans.FacilityContent;
import beans.Manager;
import beans.Training;

public class FacilityContentDao extends GenericDao<String, FacilityContent, FacilityContentDao>{
	@Override
	protected String getKey(FacilityContent entity) {
		// TODO Auto-generated method stub
		return entity.getId();
	}

	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "facilityContent.json";
	}
	public Map<String,FacilityContent> getAllToMap(){
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(getPath())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Type empMapType = new TypeToken<Map<String, FacilityContent>>() {
		}.getType();

		Map<String, FacilityContent> map = gs.fromJson(json, empMapType);
		return map;
		
	}

	@Override
	public ArrayList<FacilityContent> getAllToList() {
		// TODO Auto-generated method stub
		return new ArrayList<FacilityContent>(getAllToMap().values());
	}
	public ArrayList<FacilityContent> getAllByFacility(String facilityId){
		ArrayList<FacilityContent> trainings = new ArrayList<FacilityContent>();
		for (FacilityContent training : getAllToList()) {
			if(training.getSportFacilityId().equals(facilityId)) {
				trainings.add(training);
			}
			
		}
		return trainings;
	}

}
