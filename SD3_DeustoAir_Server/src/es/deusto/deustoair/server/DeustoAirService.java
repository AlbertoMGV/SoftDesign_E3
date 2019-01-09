package es.deusto.deustoair.server;

import es.deusto.deustoair.db.DeustoAirDatabase;
import es.deusto.deustoair.server.data.User;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.DataObjectAssembler;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.ReservationDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;
import es.deusto.deustoair.server.gateway.IAuthGateway;
import es.deusto.deustoair.server.gateway.LoginGatewayFactory;

public class DeustoAirService {
	
	private User loggedUser = null;
	
	public synchronized boolean register(String email, String password, String authMethod, String preferredPaymentMethod,AirportDTO defaultAirport) {
		if(login(email, password, authMethod)) {
			User u = new User((int) (Math.random() * 10000), email, preferredPaymentMethod, DataObjectAssembler.);
		}
		return true;
	}
	public synchronized boolean login(String email, String password, String authMethod) {
		boolean result = false;
		IAuthGateway authGateway = LoginGatewayFactory.createGateway(email, password, authMethod);
		if(DeustoAirDatabase.getUser(email) != null) {
			result = authGateway.login();
		}
		return result;
	}

	public synchronized FlightDTO[] searchFlights(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) {
		return null;
	}
	
	public synchronized boolean orderFlight(FlightDTO flight, int seats, UserDTO user) {
		return true;
	}
	
	public synchronized PaymentDTO pay(ReservationDTO res, String args, String type) {
		return null;
	}
	
	
	
	
}
