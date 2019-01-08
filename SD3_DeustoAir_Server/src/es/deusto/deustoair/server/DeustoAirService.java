package es.deusto.deustoair.server;

import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;

public class DeustoAirService {
	
	public synchronized boolean register(String username, String password, String authMethod, AirportDTO defaultAirport) {
		return true;
	}
	public synchronized boolean login(String username, String password, String authMethod) {
		return true;
	}

	public synchronized FlightDTO[] login(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) {
		return null;
	}
	
	public synchronized boolean orderFlight(FlightDTO flight, int seats, UserDTO user) {
		return true;
	}
	
	public synchronized PaymentDTO pay() {
		return null;
	}
	
	
	
	
}
