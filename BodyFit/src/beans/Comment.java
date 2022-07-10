package beans;

public class Comment {
	private String id;
	private String customerId; 
	private String sportFacilityId; 
	private String text;
	private int rating;
	private boolean state;
	
	public Comment(String id, String customerId, String sportFacilityId, String text, int rating, boolean state) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.sportFacilityId = sportFacilityId;
		this.text = text;
		this.rating = rating;
		this.state = state;
	}
	
	
	public Comment(String customerId, String sportFacilityId, String text, int rating, boolean state) {
		super();
		this.customerId = customerId;
		this.sportFacilityId = sportFacilityId;
		this.text = text;
		this.rating = rating;
		this.state = state;
	}

	

	public Comment() {
		super();
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSportFacilityId() {
		return sportFacilityId;
	}
	public void setSportFacilityId(String sportFacilityId) {
		this.sportFacilityId = sportFacilityId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	

}
