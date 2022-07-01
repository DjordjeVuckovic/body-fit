package beans;

import java.util.Date;

public class Manager extends User{
	private String sportFacilityId="";

	public Manager(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole, String sportFacilityId) {
		super(username, password, name, surname, birthdate, gender, userRole);
		// TODO Auto-generated constructor stub
		this.setUserRole(UserRole.MANAGER);
		this.setSportFacilityId(sportFacilityId);
	}
	public Manager(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole) {
		super(username, password, name, surname, birthdate, gender, userRole);
		// TODO Auto-generated constructor stub
		this.setUserRole(UserRole.MANAGER);
		this.setSportFacilityId("");
	}
	
	public Manager() {
		super();
	}
	public String getSportFacilityId() {
		return sportFacilityId;
	}
	public void setSportFacility(SportFacility facility) {
		this.setSportFacilityId(facility.getName());
	}

	public void setSportFacilityId(String sportFacilityId) {
		this.sportFacilityId = sportFacilityId;
	}
	
}
