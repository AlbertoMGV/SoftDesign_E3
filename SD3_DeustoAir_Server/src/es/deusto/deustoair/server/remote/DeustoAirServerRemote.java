package es.deusto.deustoair.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.deustoair.server.DeustoAirService;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;

public class DeustoAirServerRemote extends UnicastRemoteObject implements IDeustoAirServerRemote {
	
	private DeustoAirService service;
	
	public DeustoAirServerRemote() throws RemoteException{
		service = new DeustoAirService();
	}
	
	@Override
	public boolean register(String username, String password, String authMethod, AirportDTO defaultAirport) throws RemoteException {
		return true;
	}
	@Override
	public boolean login(String username, String password, String authMethod) throws RemoteException {
		return true;
	}
	@Override
	public FlightDTO[] login(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) throws RemoteException {
		return null;
	}
	@Override
	public boolean orderFlight(FlightDTO flight, int seats, UserDTO user) throws RemoteException {
		return true;
	}
	@Override
	public PaymentDTO pay() throws RemoteException {
		return null;
	}

}
