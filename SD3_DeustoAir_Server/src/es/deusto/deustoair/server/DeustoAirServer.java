package es.deusto.deustoair.server;

import java.rmi.Naming;

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
			System.out.println("login test: " + serverRemote.login("test@gmail.com", "test", "google"));
		} catch (Exception e) {
			System.err.println("$ DeustoAir exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
