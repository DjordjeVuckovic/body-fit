package dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import beans.ScheduleTraning;

public class ScheduleTraningDto {
	public Date dateAssign;
	public Date dateTraining;
	public String traningId;
	public String customerId;
	public String startTime;
	public String finishTime;
	public String id;
	public boolean status;
	
	public LocalTime parseTimeS() {
		return LocalTime.parse(startTime);
	}
	public ScheduleTraningDto() {
		super();
	}
	public LocalTime parseTimeF() {
		return LocalTime.parse(finishTime);
	}
	public ScheduleTraningDto(ScheduleTraning training) {
		this.dateAssign = training.getDateAssign();
		this.dateTraining = training.getDateTraining();
		this.traningId = training.getTraningId();
		this.customerId = training.getCustomerId();
		this.startTime = FormatDate(training.getStartTime());
		this.finishTime = FormatDate(training.getFinishTime());
		this.id = training.getId();
		this.status = training.isStatus();
	}
	public String FormatDate(LocalTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
		String timeString = time.format(formatter);
		return timeString;
	}
	
}
