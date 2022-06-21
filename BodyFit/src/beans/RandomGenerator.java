package beans;

import java.util.UUID;

public class RandomGenerator {
	
	public RandomGenerator() {
		// TODO Auto-generated constructor stub
	}
	public static String usingRandomUUID() {

	    UUID randomUUID = UUID.randomUUID();

	    return randomUUID.toString().replaceAll("_", "");

	  }
}
