package es.deusto.deustoair.server.data;

import java.util.Date;

public class Reservation {
	
	private int id;
	private Date date;
	private int price;
	private int airlineComission;
	private FlightBooking[] bookedFlights;
	private User bookedBy;
	private Payment payment;
	
	public Reservation(int id, Date date, int airlineComission, FlightBooking[] bookedFlights, User bookedBy, int price) {
		this.id = id;
		this.date = date;
		this.airlineComission = airlineComission;
		this.bookedFlights = bookedFlights;
		this.bookedBy = bookedBy;
		if(price == 0) {
			this.price = calcPrice();
		}
		//Orders aren't paid at the same time as reserving so there will never be a payment before a Reservation, it must be added later via setter
		this.payment = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public int getAirlineComission() {
		return airlineComission;
	}
	public void setAirlineComission(int airlineComission) {
		this.airlineComission = airlineComission;
	}
	public FlightBooking[] getBookedFlights() {
		return bookedFlights;
	}
	public void setBookedFlights(FlightBooking[] bookedFlights) {
		this.bookedFlights = bookedFlights;
	}
	public User getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}
	
	private int calcPrice() {
		int res = 0;
		for(int i = 0; i < bookedFlights.length; i++) {
			res += bookedFlights[i].getPrice();
		}
		return res;
	}
	
	

}
