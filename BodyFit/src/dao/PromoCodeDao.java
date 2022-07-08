package dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import beans.PromoCode;

public class PromoCodeDao extends GenericDao<String, PromoCode, PromoCodeDao>  {

	@Override
	protected String getKey(PromoCode entity) {
		// TODO Auto-generated method stub
		return entity.getCode();
	}

	@Override
	protected String getFilePath() {
		// TODO Auto-generated method stub
		return "PromoCode.json";
	}
	
	public Map<String,PromoCode> getAllToMap(){
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(getPath())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Type empMapType = new TypeToken<Map<String, PromoCode>>() {
		}.getType();

		Map<String, PromoCode> map = gs.fromJson(json, empMapType);
		return map;
		
	}

	@Override
	public ArrayList<PromoCode> getAllToList() {
		// TODO Auto-generated method stub
		return new ArrayList<PromoCode>(getAllToMap().values());
	}

}
