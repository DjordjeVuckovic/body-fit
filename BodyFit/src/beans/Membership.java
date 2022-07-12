package beans;

import java.util.Date;

public class Membership {
	private String id;//10 characters
	private MembershipType type;
	private Date paymentDate;
	private Date dateAndTimeOfValidity;
	private int price;
	private String customerId;
	private boolean isActive;
	private int numberOfSession;
	private int startSesions;
	
	
	public Membership() {
		super();
	}


	public Membership(String id, MembershipType type, Date paymentDate, Date dateAndTimeOfValidity, int price, String customerId,
			boolean status, int numberOfSession,int startSesions) {
		super();
		this.id = id;
		this.type = type;
		this.paymentDate = paymentDate;
		this.dateAndTimeOfValidity = dateAndTimeOfValidity;
		this.price = price;
		this.customerId = customerId;
		this.isActive = status;
		this.numberOfSession = numberOfSession;
		this.startSesions=startSesions;
	}
	
	
	public int getStartSesions() {
		return startSesions;
	}


	public void setStartSesions(int startSesions) {
		this.startSesions = startSesions;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MembershipType getType() {
		return type;
	}
	public void setType(MembershipType type) {
		this.type = type;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getDateAndTimeOfValidity() {
		return dateAndTimeOfValidity;
	}
	public void setDateAndTimeOfValidity(Date dateAndTimeOfValidity) {
		this.dateAndTimeOfValidity = dateAndTimeOfValidity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean status) {
		this.isActive = status;
	}
	public int getNumberOfSession() {
		return numberOfSession;
	}
	public void setNumberOfSession(int numberOfSession) {
		this.numberOfSession = numberOfSession;
	}
	@Override
	public String toString() {
		return "Due [id=" + id + ", type=" + type + ", paymentDate=" + paymentDate + ", dateAndTimeOfValidity="
				+ dateAndTimeOfValidity + ", price=" + price + ", customerId=" + customerId + ", status=" + isActive
				+ ", numberOfSession=" + numberOfSession + "]";
	}
	

}
