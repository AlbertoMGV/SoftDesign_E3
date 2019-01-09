package es.deusto.deustoair.client.controller;

import java.rmi.RemoteException;

import es.deusto.deustoair.client.gui.SearchWindow;

public class MainController {

	public MainController(String[] args) throws RemoteException {
		new SearchWindow(this);
		
		
	}
	public static void main(String[] args) throws RemoteException {
		new MainController(args);
	}
}
