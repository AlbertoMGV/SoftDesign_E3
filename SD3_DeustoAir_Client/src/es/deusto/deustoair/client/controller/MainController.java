package es.deusto.deustoair.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import es.deusto.deustoair.client.gui.MainWindow;

public class MainController {

	public MainController(String[] args) throws RemoteException {
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
}
