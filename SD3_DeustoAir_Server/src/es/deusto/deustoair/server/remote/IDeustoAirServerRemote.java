package es.deusto.deustoair.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.ReservationDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;

import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;

public interface IDeustoAirServerRemote extends Remote {
	public boolean register(String username, String password, String authMethod, AirportDTO defaultAirport) throws RemoteException;
	public boolean login(String username, String password, String authMethod) throws RemoteException;
	public FlightDTO[] searchFlights(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) throws RemoteException;	
	public boolean orderFlight(FlightDTO flight, int seats, UserDTO user) throws RemoteException;
	public PaymentDTO pay(ReservationDTO res, String args, String type) throws RemoteException;

	public User getUser(String emailUser) throws RemoteException;
	public Flight getFlight(String codeFlight) throws RemoteException;
	public void storeReservation(User usr) throws RemoteException;
}
