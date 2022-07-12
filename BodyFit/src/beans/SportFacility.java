package beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class SportFacility {
	private String sportFacilityId;
	private String name;
	private FacilityType type;
	private ArrayList<String> facilityContent;
	private boolean isWorking;
	private Adress currentLocation;
	private double averageGrade;
	private LocalTime openTime;
	private LocalTime closeTime;
	private boolean deleted;
	
	public SportFacility() {
		super();
	}
	
	public SportFacility(String sportFacilityId, String name, FacilityType type, Adress currentLocation,
			double averageGrade) {
		super();
		this.sportFacilityId = sportFacilityId;
		this.name = name;
		this.type = type;
		this.currentLocation = currentLocation;
		this.averageGrade = averageGrade;
		this.facilityContent = new ArrayList<String>();
		this.deleted = false;
		this.isWorking = true;
	}
	public SportFacility(String sportFacilityId, String name, FacilityType type, Adress currentLocation,
			double averageGrade,LocalTime openTime, LocalTime closeTime) {
		super();
		this.sportFacilityId = sportFacilityId;
		this.name = name;
		this.type = type;
		this.currentLocation = currentLocation;
		this.averageGrade = averageGrade;
		this.facilityContent = new ArrayList<String>();
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.deleted = false;
		this.isWorking = true;
	}
	public SportFacility(String sportFacilityId, String name, FacilityType type,
			boolean status,Adress location, double averageGrade, LocalTime openTime, LocalTime closeTime) {
		super();
		this.sportFacilityId = sportFacilityId;
		this.name = name;
		this.type = type;
		this.isWorking = status;
		this.averageGrade = averageGrade;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.facilityContent = new ArrayList<String>();
		this.deleted = false;
	}

	public String getSportFacilityId() {
		return sportFacilityId;
	}
	public void setSportFacilityId(String sportFacilityId) {
		this.sportFacilityId = sportFacilityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FacilityType getType() {
		return type;
	}
	public void setType(FacilityType type) {
		this.type = type;
	}
	public ArrayList<String> getFacilityContent() {
		return facilityContent;
	}
	public void setFacilityContent(ArrayList<String> facilityContent) {
		this.facilityContent = facilityContent;
	}
	public boolean isWorikng() {
		return isWorking;
	}
	public void setWorikng(boolean status) {
		this.isWorking = status;
	}
	public double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public LocalTime getOpenTime() {
		return openTime;
	}
	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}
	public LocalTime getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}
	public void addContent(String contentId) {
		if(!this.facilityContent.contains(contentId))
			this.facilityContent.add(contentId);
		
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Adress getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Adress currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
	
}
