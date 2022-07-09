package dto;

import java.time.LocalTime;
import java.util.Date;

public class ScheduleTraningDto {
	public Date dateAssign;
	public Date dateTraining;
	public String traningId;
	public String customerId;
	public String startTime;
	public String finishTime;
	public LocalTime parseTimeS() {
		return LocalTime.parse(startTime);
	}
	public LocalTime parseTimeF() {
		return LocalTime.parse(finishTime);
	}
}
