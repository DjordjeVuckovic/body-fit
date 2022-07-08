package beans;

import java.util.Date;

public class PromoCode {
	private String code;
	private Date dateOfValidity;
	private int quantity;
	private int discount;
	public PromoCode(String code, Date dateOfValidity, int quantity, int discount) {
		super();
		this.code = code;
		this.dateOfValidity = dateOfValidity;
		this.quantity = quantity;
		this.discount = discount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDateOfValidity() {
		return dateOfValidity;
	}
	public void setDateOfValidity(Date dateOfValidity) {
		this.dateOfValidity = dateOfValidity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public PromoCode() {
		super();
	}
	
}	
