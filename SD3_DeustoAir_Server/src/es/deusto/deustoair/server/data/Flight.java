package es.deusto.deustoair.server.data;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Flight extends Route {
	
	@PrimaryKey
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
		return "Flight [departureDateTime=" + departureDateTime + ", availableSeats=" + availableSeats + ", price="
				+ price + ", airlineCode=" + airlineCode + ", fltNumber=" + fltNumber + ", duration=" + duration
				+ ", totalSeats=" + totalSeats + ", origin=" + origin + ", destination=" + destination
				+ ", scheduledFlights=" + scheduledFlights + "]";
	}

}
