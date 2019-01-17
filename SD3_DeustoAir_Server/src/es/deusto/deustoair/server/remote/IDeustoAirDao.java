package es.deusto.deustoair.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;



import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;

public interface IDeustoAirDao extends Remote {
	public User getUser(String emailUser) throws RemoteException;
	public Flight getFlight(String codeFlight) throws RemoteException;
	public void storeReservation(User usr) throws RemoteException;
}
