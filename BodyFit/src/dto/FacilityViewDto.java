package dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import beans.FacilityType;
import beans.SportFacility;

public class FacilityViewDto {
	public String id;
	public String name;
	public String type; 
	public String status;
	public String city;
	public String postal;
	public String address;
	public String lat;
	public String longi;
	public String startTime;
	public String finishTime;
	//public String logitude;
	//public String latitude;
	public String rating;
	public LocalTime parseTimeS() {
		return LocalTime.parse(startTime);
	}
	public LocalTime parseTimeF() {
		return LocalTime.parse(finishTime);
	}
	public FacilityViewDto(SportFacility facility) {
		this.id = facility.getSportFacilityId();
		this.name = facility.getName();
		this.type = facility.getType().toString();
		this.status = isWorkingToString(facility);
		this.city = facility.getCurrentLocation().getCity();
		this.postal = facility.getCurrentLocation().getPostalCode();
		this.address = facility.getCurrentLocation().getStreetAndNumber();
		this.longi = facility.getCurrentLocation().getLongitude();
		this.lat = facility.getCurrentLocation().getLatitude();
		this.rating = String.valueOf(facility.getAverageGrade());
		this.startTime = FormatDate(facility.getOpenTime());
		this.finishTime= FormatDate(facility.getCloseTime());
	}
	public FacilityViewDto() {
		super();	
	}
	private String isWorkingToString(SportFacility facility) {
		if(facility.isWorikng()) {
			return "Working";
		}
		else {
			return "Not working";
		}
	}
	private String FormatDate(LocalTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
		String timeString = time.format(formatter);
		return timeString;
	}

}
