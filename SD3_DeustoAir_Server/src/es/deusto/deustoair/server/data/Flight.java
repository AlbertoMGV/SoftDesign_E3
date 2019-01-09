package es.deusto.deustoair.server.data;

import java.util.Date;

public class Flight extends Route {
	
	private Date departureDateTime;
	private int availableSeats;
	private int price;
	
	public Flight(Route r, Date departureDateTime, int price) {
		super(r.airlineCode, r.fltNumber, r.duration, r.totalSeats, r.destination, r.destination);
		this.availableSeats = r.totalSeats;
		this.departureDateTime = departureDateTime;
		this.price = price;
	}
	public Flight(String airlineCode, int fltNumber, int duration, int totalSeats, Date departureDateTime,
			int availableSeats, Airport origin, Airport destination, int price) {
		super(airlineCode, fltNumber, duration, totalSeats, destination, destination);
		this.departureDateTime = departureDateTime;
		this.availableSeats = availableSeats;
		this.price = price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public Date getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public Date getArrivalDateTime() {
		return new Date(this.departureDateTime.getTime() + 60000 * this.duration);
	}

}
