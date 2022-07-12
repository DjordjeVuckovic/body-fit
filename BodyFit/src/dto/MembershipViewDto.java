package dto;

import java.util.Date;

import beans.Membership;
import beans.MembershipType;

public class MembershipViewDto {
	public String type;
	public Date paymentDate;
	public Date dateAndTimeOfValidity;
	public int price;
	public String customerId;
	public boolean isActive;
	public int numberOfSession;
	public int startSesions;
	public MembershipViewDto(Membership membership) {
		this.type = membership.getType().toString();
		this.paymentDate = membership.getPaymentDate();
		this.dateAndTimeOfValidity = membership.getDateAndTimeOfValidity();
		this.price = membership.getPrice();
		this.customerId = membership.getCustomerId();
		this.isActive = membership.isActive();
		this.numberOfSession = membership.getNumberOfSession();
		this.startSesions = membership.getStartSesions();
	}
	public MembershipViewDto() {	
	}

	
	
}
