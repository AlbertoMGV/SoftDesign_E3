package com.ryanair.data;

import java.util.Date;


public class Flight extends Route{
	

	private Date departureDateTime;
	private int availableSeats;
	private int price;
	
	public Flight(Route r, Date departureDateTime, int price) {
		super(r.airlineCode, r.fltNumber, r.duration, r.totalSeats, r.origin, r.destination);
		this.availableSeats = r.totalSeats;
		this.departureDateTime = departureDateTime;
		this.price = price;
	}
	public Flight(String airlineCode, int fltNumber, int duration, int totalSeats, Date departureDateTime,
			int availableSeats, String origin, String destination, int price) {
		super(airlineCode, fltNumber, duration, totalSeats, origin, destination);
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
	
	@Override
	public String toString() {
		return airlineCode + ";" + fltNumber + ";" + duration + ";" + totalSeats + ";" + departureDateTime.getTime() + ";" + availableSeats + ";" + origin + ";" + destination + ";" + price;
	}



}
