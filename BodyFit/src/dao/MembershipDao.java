package dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import beans.Admin;
import beans.Membership;

public class MembershipDao extends GenericDao<String,Membership, MembershipDao>{

	@Override
	protected String getKey(Membership entity) {
		// TODO Auto-generated method stub
		return entity.getId();
	}

	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "Membership.json";
	}
	
	public Map<String,Membership> getAllToMap(){
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(getPath())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Type empMapType = new TypeToken<Map<String, Membership>>() {
		}.getType();

		Map<String, Membership> map = gs.fromJson(json, empMapType);
		return map;
	}
	
	@Override
	public ArrayList<Membership> getAllToList() {
		// TODO Auto-generated method stub
		return new ArrayList<Membership>(getAllToMap().values());
	}


}
