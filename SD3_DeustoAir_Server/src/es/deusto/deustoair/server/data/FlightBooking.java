package es.deusto.deustoair.server.data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class FlightBooking {
	
	private Flight flight;
	private String[] seats;
	private String[] travellers;
	
	public FlightBooking(Flight flight, String[] seats, String[] travellers) {
		this.flight = flight;
		this.seats = seats;
		this.travellers = travellers;
	}
	
	public int getPrice() {
		return flight.getPrice() * seats.length;
	}
	
	public String[] getSeats() {
		return seats;
	}
	public void setSeatName(String[] seats) {
		this.seats = seats;
	}
	public String[] getTravellers() {
		return travellers;
	}
	public void setTravellers(String[] travellers) {
		this.travellers = travellers;
	}

}
