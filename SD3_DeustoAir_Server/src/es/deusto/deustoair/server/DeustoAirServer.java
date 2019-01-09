package es.deusto.deustoair.server;

import java.rmi.Naming;
import java.text.SimpleDateFormat;

import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.remote.DeustoAirServerRemote;
import es.deusto.deustoair.server.remote.IDeustoAirServerRemote;

public class DeustoAirServer {
	
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		
		String serverName = "//" + args[0] + ":" + args[1] + "/" + args[2];
		

		try {			
			IDeustoAirServerRemote serverRemote = new DeustoAirServerRemote();			
			Naming.rebind(serverName, serverRemote);
			System.out.println("* Main DeustoAir Server now running on: '" + serverName);
			AirportDTO bio = new AirportDTO("BIO", "Loiu Airport", "Bilbao", "Spain");
			AirportDTO mad = new AirportDTO("MAD", "Adolfo Suarez Airport", "Madrid", "Spain");
			FlightDTO[] flts = serverRemote.searchFlights(bio, mad, "08/01/2019", "14/01/2019", 1);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			for(int i = 0; i < flts.length; i++) {
				System.out.println(flts[i] . getFltNumber() + ": " + format.format(flts[i].getDepartureDateTime()));
			}
			//serverRemote.register("test@gmail.com", "test", "google", bio);
			//System.out.println("login test: " + serverRemote.login("test@gmail.com", "test", "google"));

		} catch (Exception e) {
			System.err.println("$ DeustoAir exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
