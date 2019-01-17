package es.deustoair.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;

public interface IDeustoAirDAO extends Remote {
	public User getUser(String emailUser) throws RemoteException;
	public Flight getFlight(String codeFlight) throws RemoteException;
	public List<User> getUsers() throws RemoteException;
	public void storeReservation(User usr) throws RemoteException;
}
