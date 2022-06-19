package beans;

public class Adress {
	private String streetAndNumber;
	private String city;
	private String postalCode;
	private String latitude;
	private String longitude;
	
	public Adress(String streetAndNumber, String city, String postalCode, String latitude, String longitude) {
		super();
		this.streetAndNumber = streetAndNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Adress(String streetAndNumber, String city, String postalCode) {
		super();
		this.streetAndNumber = streetAndNumber;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Adress [streetAndNumber=" + streetAndNumber + ", city=" + city + ", postalCode=" + postalCode + "]";
	}

}
