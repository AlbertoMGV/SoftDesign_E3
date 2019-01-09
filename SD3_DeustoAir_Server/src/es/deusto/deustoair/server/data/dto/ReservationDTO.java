package es.deusto.deustoair.server.data.dto;

import java.util.Date;

public class ReservationDTO {
	
	private int id;
	private long date;
	private int price;
		
	public ReservationDTO(int id, long date, int price) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
