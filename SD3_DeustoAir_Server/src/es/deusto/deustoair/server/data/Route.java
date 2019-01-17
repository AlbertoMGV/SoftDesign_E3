package es.deusto.deustoair.server.data;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Route {
	
	protected String airlineCode;
	@PrimaryKey
	protected int fltNumber;
	protected int duration;
	protected int totalSeats;
	protected Airport origin, destination;
	protected ArrayList<Flight> scheduledFlights;
	
	public Route(String airlineCode, int fltNumber, int duration, int totalSeats, Airport origin, Airport destination) {
		super();
		this.scheduledFlights = new ArrayList<Flight>();
		this.airlineCode = airlineCode;
		this.fltNumber = fltNumber;
		this.duration = duration;
		this.totalSeats = totalSeats;
		this.origin = origin;
		this.destination = destination;
	}
	
	public Flight createFlight(Date departureDateTime, int price) {
		Flight f = new Flight(this, departureDateTime, price);
		scheduledFlights.add(f);
		return f;
	}
	
	public void addFlight(Flight f) {
		this.scheduledFlights.add(f);
	}
	
	public Flight[] getScheduledFlights() {
		return (Flight[]) this.scheduledFlights.toArray();
	}
	
	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public String getAirlineCode() {
		return airlineCode;
	}
	
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	
	public int getFltNumber() {
		return fltNumber;
	}
	
	public void setFltNumber(int fltNumber) {
		this.fltNumber = fltNumber;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	
}
