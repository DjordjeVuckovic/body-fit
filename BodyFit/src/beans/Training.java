package beans;

import java.time.Duration;

public class Training extends FacilityContent {
	private TrainingType type;
	private String sportFacilityId;
	private String trainerId;
	public Training(String id, String name, FacilityContentType facilityContentType, String description, int duration,
			boolean deleted, TrainingType type, String sportFacilityId, String trainerId) {
		super(id, name, facilityContentType, description, duration, deleted);
		this.type = type;
		this.sportFacilityId = sportFacilityId;
		this.trainerId = trainerId;
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
