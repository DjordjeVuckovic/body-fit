package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import beans.Admin;
import beans.Adress;
import beans.Customer;
import beans.FacilityContent;
import beans.FacilityContentType;
import beans.FacilityType;
import beans.Gender;
import beans.GeoLocation;
import beans.Location;
import beans.SportFacility;
import beans.Trainer;
import beans.Training;
import beans.TrainingType;
import beans.UserRole;
import dao.AdminDao;
import dao.CustomerDao;
import dao.FacilityContentDao;
import dao.SportFacilityDao;
import dao.TrainerDao;
import dao.TrainingDao;

public class Mian {

	public static void main(String[] args) {
//		SportFacilityDao facilityDao = new SportFacilityDao(); 
//		facilityDao.setBasePath("C:\\Users\\djord\\OneDrive\\Documents\\GitHub\\WebProject\\BodyFit\\src\\jsonData\\");
//		SportFacility fac = facilityDao.getById("2");
//		System.out.println(fac.getName());
		
		TrainingDao trainingDao = new TrainingDao();
		trainingDao.setBasePath("src/jsonData/");
//		ArrayList<Training> tr = trainingDao.getAllByManager("2");
//		ArrayList<Trainer> tr1 = trainingDao.getAllTrainersForTrainings("2");
//		for (Trainer tra: tr1) {
//			System.out.println(tra.getUsername());
//		}
		Training tr =  trainingDao.getById("0");
		System.out.println(tr.getName());
		
//		
//		System.out.println(tr.isEmpty());
//		for (Training tra: tr) {
//			System.out.println(tra.getId());
//		}
		
		// TODO Auto-generated method stub
//		Date date = new Date();
//		CustomerDao customerDao = new CustomerDao();
//		customerDao.setBasePath("src/jsonData/");
//		Customer customer = new Customer("lm", "mikia", "m", "m",date, Gender.FEMALE, UserRole.CUSTOMER, 11);
		//File fileRelative3 = new File("src/jsonData/pdf-sample.pdf");
//		String str = "C:\\\\Users\\\\djord\\\\OneDrive\\\\Documents\\\\GitHub\\\\WebProject\\\\BodyFit\\\\src\\\\jsonData\\";
//		System.out.println(fileRelative3.getPath());
//		System.out.println(fileRelative3.getAbsolutePath());
		//customerDao.create(customer);
		
//		
//
////		SportFacilityDao facilityDao = new SportFacilityDao();
////
////		SportFacility facility = new SportFacility("7", "Flex", FacilityType.GYM, new ArrayList<>() , false, "dgasfdfsgdgasgf", 4.4, date, date);
////
////		
////		facilityDao.create(facility);
//		SportFacilityDao facilityDao = new SportFacilityDao();
//		Adress adress = new Adress("Veselina Maslese 84","Novi Sad","2100","45,11","19.84");
//		SportFacility facility = new SportFacility("1",  "Synergy", FacilityType.GYM, adress,
//				9.0);
//		facilityDao.setBasePath("C:\\Users\\djord\\OneDrive\\Documents\\GitHub\\WebProject\\BodyFit\\src\\jsonData\\");
//		facilityDao.create(facility);
		

		}
		
		

}
