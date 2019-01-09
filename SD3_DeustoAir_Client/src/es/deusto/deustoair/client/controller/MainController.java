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
		//make search
		System.out.println("* MainController");
		ArrayList<String> SList= new ArrayList<String>();
		SList.add("aaaa");
		SList.add("bbbb");
		SList.add("cccc");
		return SList;
	}
}
