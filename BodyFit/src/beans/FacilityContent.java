package beans;

public class FacilityContent {
	private String id;
	private String name;
	private FacilityContentType facilityContentType;
	private String description;
	private int duration;
	private boolean deleted;
	public FacilityContent(String id, String name, FacilityContentType facilityContentType, String description,
			int duration, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.facilityContentType = facilityContentType;
		this.description = description;
		this.duration = duration;
		this.deleted = deleted;
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
	public FacilityContentType getFacilityContentType() {
		return facilityContentType;
	}
	public void setFacilityContentType(FacilityContentType facilityContentType) {
		this.facilityContentType = facilityContentType;
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	

}
