package es.deusto.deustoair.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

import es.deusto.deustoair.client.gui.MainWindow;
import es.deusto.deustoair.client.remote.RMIServiceLocator;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.remote.IDeustoAirServerRemote;

public class MainController {

	
	private RMIServiceLocator rsl;
	IDeustoAirServerRemote srv;
	
	
	public MainController(String[] args) throws RemoteException {
		
		
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		srv = rsl.getDeustoService();
		new MainWindow(this);
				
		
	}
	public static void main(String[] args) throws RemoteException {
		new MainController(args);
	}
	public FlightDTO[] getSearch(String from, String to, String Ddepart, String Dreturn, int snum) {
		//make search, luego con los objs
		AirportDTO AF = new AirportDTO(from);
		AirportDTO AT = new AirportDTO(to);
		FlightDTO[] search = null;
		
		try {
			System.out.println("* Busqueda");
			search = srv.searchFlights(AF, AT, Ddepart, Dreturn, snum);
			System.out.println(search.toString());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return search;
	}
	public ArrayList<String> getReservations(String from) {
		
		System.out.println("* Get Reservas");
		ArrayList<String> RList= new ArrayList<String>();
		RList.add("Madrid - Bilbao | 10/3/19-24/3/19 | 40�");
		RList.add("Santander - Oviedo| 19/3/19-24/3/19 | 50�");
		RList.add("Portugalete - Sestao | 28/3/19-24/3/19 | 60�");
		return RList;
	}
	public boolean register(String email,String pass,String authm,AirportDTO homeAir) {
			
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
