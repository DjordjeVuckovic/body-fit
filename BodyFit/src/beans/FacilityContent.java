package beans;

public class FacilityContent {
	private String id;
	private String name;
	private String description;
	private int duration;
	private String sportFacilityId;
	private boolean deleted;
	private double additionalPrice;
	
	public FacilityContent() {
		super();
	}
	public FacilityContent(String id, String name, String description, int duration, String sportFacilityId,
			boolean deleted, double additionalPrice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.sportFacilityId = sportFacilityId;
		this.deleted = deleted;
		this.additionalPrice = additionalPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getSportFacilityId() {
		return sportFacilityId;
	}
	public void setSportFacilityId(String sportFacilityId) {
		this.sportFacilityId = sportFacilityId;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public double getAdditionalPrice() {
		return additionalPrice;
	}
	public void setAdditionalPrice(double additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
	
	
}
