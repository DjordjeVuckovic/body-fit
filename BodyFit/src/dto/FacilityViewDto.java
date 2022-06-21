package dto;

import beans.FacilityType;
import beans.SportFacility;

public class FacilityViewDto {
	public String name;
	public String type; 
	public String status;
	public String city;
	public String postal;
	public String address;
	public String location;
	public String lat;
	public String longi;
	public String rating;
	public FacilityViewDto(SportFacility facility) {
		this.name = facility.getName();
		this.type = facility.getType().toString();
		this.status = isWorkingToString(facility);
		//this.location = facility.getLocation();
		this.city = facility.getCurrentLocation().getCity();
		this.postal = facility.getCurrentLocation().getPostalCode();
		this.address = facility.getCurrentLocation().getStreetAndNumber();
		this.longi = facility.getCurrentLocation().getLongitude();
		this.lat = facility.getCurrentLocation().getLatitude();
		this.rating = String.valueOf(facility.getAverageGrade());
	}
	public FacilityViewDto() {
		this.name = "NO_FACILITIES";
		this.type = null;
		this.status = null;
		//this.location= null;
		this.rating = null;		
	}
	private String isWorkingToString(SportFacility facility) {
		if(facility.isWorikng()) {
			return "Working";
		}
		else {
			return "Closed";
		}
	}

}
