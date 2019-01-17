package es.deusto.deustoair.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import es.deusto.deustoair.server.DeustoAirService;

import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.ReservationDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;

public class DeustoAirServerRemote extends UnicastRemoteObject implements IDeustoAirServerRemote {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DeustoAirService service;
	
	public DeustoAirServerRemote(DeustoAirService service) throws RemoteException{
		this.service = service;
		
	}
	
	@Override
	public boolean register(String username, String password, String authMethod, AirportDTO defaultAirport) throws RemoteException {
		return service.register(username, password, authMethod, "paypal", defaultAirport);
	}
	@Override
	public boolean login(String username, String password, String authMethod) throws RemoteException {
		return service.login(username, password, authMethod, false);
	}
	@Override
	public FlightDTO[] searchFlights(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) throws RemoteException {
		return service.searchFlights(origin, destination, dDate, rDate, seats);
	}
	@Override
	public boolean orderFlight(FlightDTO flight, int seats, UserDTO user) throws RemoteException {
		return service.orderFlight(flight, seats, user);
	}
	@Override
	public PaymentDTO pay(ReservationDTO res, String args, String type) throws RemoteException {
		return service.pay(res, args, type);
	}

	

}
