package beans;


public class Training {
	private String id;
	private TrainingType type;
	private String sportFacilityId;
	private String trainerId;
	private String name;
	private String description;
	private int duration;
	private boolean deleted;
	private double additionalPrice;
	public double getAdditionalPrice() {
		return additionalPrice;
	}
	public void setAdditionalPrice(double additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
	public Training(String id, TrainingType type, String sportFacilityId, String trainerId, String name,
			String description, int duration,double additionalPrice, boolean deleted) {
		super();
		this.id = id;
		this.type = type;
		this.sportFacilityId = sportFacilityId;
		this.trainerId = trainerId;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.deleted = deleted;
		this.additionalPrice = additionalPrice;
	}
	
	public Training() {
		
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public TrainingType getType() {
		return type;
	}
	public void setType(TrainingType type) {
		this.type = type;
	}
	public String getSportFacilityId() {
		return sportFacilityId;
	}
	public void setSportFacilityId(String sportFacilityId) {
		this.sportFacilityId = sportFacilityId;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	

}
