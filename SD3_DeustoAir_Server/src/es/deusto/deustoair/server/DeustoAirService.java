package es.deusto.deustoair.server;

import es.deusto.deustoair.db.DeustoAirDatabase;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.DataObjectAssembler;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.ReservationDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;
import es.deusto.deustoair.server.gateway.FlightSearchController;
import es.deusto.deustoair.server.gateway.IAuthGateway;
import es.deusto.deustoair.server.gateway.LoginGatewayFactory;

public class DeustoAirService {
	
	private User loggedUser = null;
	
	public synchronized boolean register(String email, String password, String authMethod, String preferredPaymentMethod,AirportDTO defaultAirport) {
		boolean result = false;
		if(login(email, password, authMethod, true)) {
			User u = new User((int) (Math.random() * 10000), email, preferredPaymentMethod, DataObjectAssembler.disassemble(defaultAirport));
			DeustoAirDatabase.store(u);
			result = true;
		}
		return result;
	}
	public synchronized boolean login(String email, String password, String authMethod, boolean reg) {
		boolean result = false;
		IAuthGateway authGateway = LoginGatewayFactory.createGateway(email, password, authMethod);
		if(DeustoAirDatabase.getUser(email) != null || reg == true) {
			result = authGateway.login();
		}
		return result;
	}

	public synchronized FlightDTO[] searchFlights(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) {
		FlightSearchController fsc = new FlightSearchController();
		Flight[] flights = fsc.searchFlights(DataObjectAssembler.disassemble(origin), DataObjectAssembler.disassemble(destination), dDate, rDate, seats);
		return DataObjectAssembler.assemble(flights);
	}
	
	public synchronized boolean orderFlight(FlightDTO flight, int seats, UserDTO user) {
		return true;
	}
	
	public synchronized PaymentDTO pay(ReservationDTO res, String args, String type) {
		return null;
	}
	
	
	
	
}
