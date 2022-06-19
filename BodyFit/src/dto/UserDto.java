package dto;

import java.util.Date;

import beans.Gender;

public class UserDto {
	public String username;
	public String password;
	public String name;
	public String surname;
	public String gender;
	public Date birthday;	
	
	public Gender gerGenderEnum() {
		if (gender.equals("Male"))
			return Gender.MALE;
		else
			return Gender.FEMALE;
	}

}
