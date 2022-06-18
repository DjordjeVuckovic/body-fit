package main;

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
import beans.FacilityType;
import beans.Gender;
import beans.GeoLocation;
import beans.Location;
import beans.SportFacility;
import beans.UserRole;
import dao.AdminDao;
import dao.CustomerDao;
import dao.SportFacilityDao;

public class Mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		Date date = new Date();
//		Customer customer = new Customer("mikiia", "mikia", "m", "m",date, Gender.FEMALE, UserRole.CUSTOMER, 11);
//		dao.create(customer);
//		AdminDao adminDao = new AdminDao();
//		Admin admin = new Admin("a", "a", "a", "a",  date,Gender.FEMALE, UserRole.ADMIN);
//		adminDao.create(admin);
		Customer customer = new Customer("laza", "lazarevic", "m", "m",date, Gender.MALE, UserRole.CUSTOMER, 11);
		//dao.setBasePath("C:\\Users\\djord\\OneDrive\\Documents\\GitHub\\WebProject\\BodyFit\\src\\jsonData\\");	
		dao.create(customer);
		
		

		SportFacilityDao facilityDao = new SportFacilityDao();

		SportFacility facility = new SportFacility("7", "Flex", FacilityType.GYM, new ArrayList<>() , false, "dgasfdfsgdgasgf", 4.4, date, date);

		
		facilityDao.create(facility);
		}
		

}
