package es.deusto.deustoair.server.data.dto;

import java.util.Date;

public class ReservationDTO {
	
	private int id;
	private Date date;
	private int price;
	private int airlineComission;
	private int user;
		
	public ReservationDTO(int id, Date date, int price, int airlineComission, int user) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.airlineComission = airlineComission;
		this.user = user;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAirlineComission() {
		return airlineComission;
	}
	public void setAirlineComission(int airlineComission) {
		this.airlineComission = airlineComission;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	

}
