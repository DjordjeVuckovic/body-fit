package beans;

import java.util.ArrayList;
import java.util.Date;

public class Trainer extends User{
	
	private ArrayList<String> trainingHistory;
	
	public Trainer(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole) {
		super(username, password, name, surname, birthdate, gender, userRole);
		// TODO Auto-generated constructor stub
		trainingHistory = new ArrayList<String>();
	}

	public Trainer(String username, String password, String name, String surname, Date birthdate, Gender gender,
			UserRole userRole, ArrayList<String> trainingHistory) {
		super(username, password, name, surname, birthdate, gender, userRole);
		this.trainingHistory = trainingHistory;
	}
	
}
