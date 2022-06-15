package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import beans.Admin;
import beans.Customer;
import beans.Gender;
import beans.UserRole;
import dao.AdminDao;
import dao.CustomerDao;

public class Mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		Date date = new Date();
		Customer customer = new Customer("mikiia", "mikia", "m", "m",date, Gender.FEMALE, UserRole.CUSTOMER, 11);
		dao.create(customer);
		AdminDao adminDao = new AdminDao();
		Admin admin = new Admin("a", "a", "a", "a",  date,Gender.FEMALE, UserRole.ADMIN);
		adminDao.create(admin);


		}

}
