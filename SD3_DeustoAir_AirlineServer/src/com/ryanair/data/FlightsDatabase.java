package com.ryanair.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class FlightsDatabase {
	
	private ArrayList<Flight> flights;
	private ArrayList<Route> routes;
	
	public FlightsDatabase() {
		flights = new ArrayList<Flight>();
		routes = new ArrayList<Route>();
		Route r = new Route("RY", 2100, 45, 150, "MAD", "BIO");
		Route r1 = new Route("RY", 2101, 45, 150, "BIO", "MAD");
		
		routes.add(r);
		routes.add(r1);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Flight f1 = new Flight(r, format.parse("09/01/2019"), 52);
			Flight f2 = new Flight(r, format.parse("10/01/2019"), 49);
			Flight f3 = new Flight(r1, format.parse("09/01/2019"), 41);
			Flight f4 = new Flight(r1, format.parse("10/01/2019"), 65);
			flights.add(f1);
			flights.add(f2);
			flights.add(f3);
			flights.add(f4);	
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public Flight[] searchFlights(String origin, String destination, String dDate, String rDate, int seats) {
		ArrayList<Flight> result = new ArrayList<Flight>();
		for(Flight f : flights) {
			if(f.getOrigin().equals(origin)) {
				if(f.getDestination().equals(destination)) {
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						if((format.parse(dDate).getTime() < f.getDepartureDateTime().getTime()) && (format.parse(rDate).getTime() > f.getArrivalDateTime().getTime())) {
							if(f.getAvailableSeats() > 0) {
								result.add(f);
							}
						}
					}catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
		Flight[] result1 = new Flight[result.size()];
		for(int i = 0; i < result.size(); i++) {
			result1[i] = result.get(i);
		}
		return result1;
	}

}
