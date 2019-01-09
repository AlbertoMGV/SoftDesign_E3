package es.deusto.deustoair.server.data;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String email;
	private String preferredPaymentMethod;
	private Airport defaultAirport;
	private ArrayList<Reservation> reservations;
	private ArrayList<Payment> payments;
	
	public User(int id, String email,String preferredPaymentMethod, Airport defaultAirport) {
		super();
		this.id = id;
		this.email = email;
		this.preferredPaymentMethod = preferredPaymentMethod;
		this.defaultAirport = defaultAirport;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPreferredPaymentMethod() {
		return preferredPaymentMethod;
	}
	public void setPreferredPaymentMethod(String preferredPaymentMethod) {
		this.preferredPaymentMethod = preferredPaymentMethod;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Airport getDefaultAirport() {
		return defaultAirport;
	}
	public void setDefaultAirport(Airport defaultAirport) {
		this.defaultAirport = defaultAirport;
	}

	public Reservation[] getReservations() {
		return (Reservation[]) reservations.toArray();
	}
	public void addReservation(Reservation r) {
		this.reservations.add(r);
	}
	public Payment[] getPayments() {
		return (Payment[]) payments.toArray();
	}
	public void addPayment(Payment p) {
		this.payments.add(p);
	}

}
