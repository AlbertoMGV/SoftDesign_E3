package es.deusto.deustoair.server.data.dto;

import java.io.Serializable;

public class FlightDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String airlineCode;
	private int fltNumber;
	private int duration;
	private int totalSeats;
	private String originCode;
	private String destinationCode;
	private long departureDateTime;
	private int price;
	
	public FlightDTO(String airlineCode, int fltNumber, int duration, int totalSeats, String originCode,
			String destinationCode, long departureDateTime, int price) {
		this.airlineCode = airlineCode;
		this.fltNumber = fltNumber;
		this.duration = duration;
		this.totalSeats = totalSeats;
		this.originCode = originCode;
		this.destinationCode = destinationCode;
		this.departureDateTime = departureDateTime;
		this.price = price;
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
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	public long getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(long departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
