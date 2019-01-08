package es.deusto.deustoair.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;

public interface IDeustoAirServerRemote extends Remote {
	public boolean register(String username, String password, String authMethod, AirportDTO defaultAirport) throws RemoteException;
	public boolean login(String username, String password, String authMethod) throws RemoteException;
	public FlightDTO[] login(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) throws RemoteException;	
	public boolean orderFlight(FlightDTO flight, int seats, UserDTO user) throws RemoteException;
	public PaymentDTO pay() throws RemoteException;
}
