package beans;

import java.time.LocalTime;
import java.util.Date;

public class ScheduleTraning {
	private Date dateAssign;
	private Date dateTraining;
	private String traningId;
	private String customerId;
	private String id;
	private LocalTime startTime;
	private LocalTime finishTime;
	private boolean status;
	
	public ScheduleTraning() {
		super();
	}
	public ScheduleTraning(Date dateAssign, Date traningDate, String traningId, String customerId) {
		super();
		this.dateAssign = dateAssign;
		this.dateTraining = traningDate;
		this.traningId = traningId;
		this.customerId = customerId;
		this.status = false;
	}
	
	public ScheduleTraning(Date dateAssign, Date dateTraining, String traningId, String customerId, String id,LocalTime startTime,LocalTime finishTime) {
		super();
		this.dateAssign = dateAssign;
		this.dateTraining = dateTraining;
		this.traningId = traningId;
		this.customerId = customerId;
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.status = false;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public Date getDateTraining() {
		return dateTraining;
	}
	public void setDateTraining(Date dateTraining) {
		this.dateTraining = dateTraining;
	}
	public LocalTime getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDateAssign() {
		return dateAssign;
	}
	public void setDateAssign(Date dateAssign) {
		this.dateAssign = dateAssign;
	}
	public Date getTraningDate() {
		return dateTraining;
	}
	public void setTraningDate(Date traningDate) {
		this.dateTraining = traningDate;
	}
	public String getTraningId() {
		return traningId;
	}
	public void setTraningId(String traningId) {
		this.traningId = traningId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
