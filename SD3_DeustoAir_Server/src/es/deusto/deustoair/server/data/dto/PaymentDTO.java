package es.deusto.deustoair.server.data.dto;

import java.util.Date;

import es.deusto.deustoair.server.data.Reservation;

public class PaymentDTO {
	
	private int id;
	private long date;
	private int paidReservationId;
	
	public PaymentDTO(int id, long date, int paidReservationId) {
		super();
		this.id = id;
		this.date = date;
		this.paidReservationId = paidReservationId;
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


	public int getPaidReservationId() {
		return paidReservationId;
	}

	public void setPaidReservationId(int paidReservationId) {
		this.paidReservationId = paidReservationId;
	}


}
