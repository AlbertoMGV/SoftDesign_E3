package es.deusto.deustoair.db;

import java.util.HashMap;

import es.deusto.deustoair.server.data.Airport;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.Payment;
import es.deusto.deustoair.server.data.Reservation;
import es.deusto.deustoair.server.data.Route;
import es.deusto.deustoair.server.data.User;

public class DeustoAirDatabase {

	//We simulate a db
	
	private static HashMap<String, User> users;
	private static HashMap<String, Airport> airports;
	private static HashMap<String, Route> routes;
	
	/*flights should have their own code to distinguish them from routes but for simplicity this will be ommited*/
	
	private static HashMap<String, Flight> flights; 
	private static HashMap<Integer, Reservation> reservations;
	private static HashMap<Integer, Payment> payments;
	
	static {
		users = new HashMap<String, User>();
		airports = new HashMap<String, Airport>();
		routes = new HashMap<String, Route>();
		flights = new HashMap<String, Flight>();
		reservations = new HashMap<Integer, Reservation>();
		payments = new HashMap<Integer, Payment>();

	}
	
	public static void store(User u) {
		users.put(u.getEmail(), u);
	}
	public static void store(Airport a) {
		airports.put(a.getCode(), a);
	}
	public static void store(Route r) {
		routes.put(r.getAirlineCode() + r.getFltNumber(), r);
	}
	public static void store(Flight f) {
		flights.put(f.getAirlineCode() + f.getFltNumber(), f);
	}
	public static void store(Reservation r) {
		reservations.put(r.getId(), r);
	}
	public static void store(Payment p) {
		payments.put(p.getId(), p);
	}
	
	public static User getUser(String email) {
		return users.get(email);
	}
	public static Airport getAirport(String id) {
		return airports.get(id);
	}
	public static Route getRoute(String code) {
		return routes.get(code);
	}
	public static Flight getFlight(String code) {
		return flights.get(code);
	}
	public static Reservation getReservation(int id) {
		return reservations.get(id);
	}
	public static Payment getPayment(int id) {
		return payments.get(id);
	}


	
}
