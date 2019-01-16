package es.deusto.deustoair.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.deustoair.client.gui.MainWindow;
import es.deusto.deustoair.client.remote.RMIServiceLocator;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.remote.IDeustoAirServerRemote;

public class MainController {

	
	private RMIServiceLocator rsl;
	
	
	public MainController(String[] args) throws RemoteException {
		
		
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		
		new MainWindow(this);
				
		
	}
	public static void main(String[] args) throws RemoteException {
		new MainController(args);
	}
	public ArrayList<String> getSearch(String from, String to, String Ddepart, String Dreturn) {
		//make search, luego con los objs
		
		
		
		System.out.println("* Get Search");
		ArrayList<String> SList= new ArrayList<String>();
		SList.add("Madrid - Bilbao | 21/3/19-24/3/19 | 40€");
		SList.add("Madrid - Bilbao | 21/3/19-24/3/19 | 50€");
		SList.add("Madrid - Bilbao | 21/3/19-24/3/19 | 60€");
		return SList;
	}
	public ArrayList<String> getReservations(String from) {
		
		System.out.println("* Get Reservas");
		ArrayList<String> RList= new ArrayList<String>();
		RList.add("Madrid - Bilbao | 10/3/19-24/3/19 | 40€");
		RList.add("Santander - Oviedo| 19/3/19-24/3/19 | 50€");
		RList.add("Portugalete - Sestao | 28/3/19-24/3/19 | 60€");
		return RList;
	}
	public boolean register(String email,String pass,String authm,AirportDTO homeAir) {
			IDeustoAirServerRemote srv = rsl.getDeustoService();
			try {
				if (srv.register(email, pass, authm, homeAir)) {
					return true;
				} else {
					return false;
				} 
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
		
		return false;
	}
}
