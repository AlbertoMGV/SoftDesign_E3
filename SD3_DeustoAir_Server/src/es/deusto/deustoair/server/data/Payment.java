package es.deusto.deustoair.server.data;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Payment {
	@PrimaryKey
	private int id;
	private Date date;
	private String paymentMethod;
	private User paidBy;
	private Reservation paidReservation;
	
	public Payment(int id, Date date, String paymentCode, String paymentMethod, Reservation paidReservation) {
		this.id = id;
		this.date = date;
		this.paymentMethod = paymentMethod;
		this.paidReservation = paidReservation;
		this.paidBy = paidReservation.getBookedBy();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Reservation getPaidReservation() {
		return paidReservation;
	}

	public void setPaidReservation(Reservation paidReservation) {
		this.paidReservation = paidReservation;
	}
	
	

}
