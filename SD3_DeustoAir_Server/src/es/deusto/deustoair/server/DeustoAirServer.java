package es.deusto.deustoair.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.sms.server.TVProgramService;
import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramAdmin;
import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramReceiver;
import es.deusto.ingenieria.sd.sms.server.remote.TVProgramAdmin;
import es.deusto.ingenieria.sd.sms.server.remote.TVProgramReceiver;

public class DeustoAirServer {
	
	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String nameAdmin = "//127.0.0.1:1099/admin";

		try {
			TVProgramService TVProgData = new TVProgramService();
			
			ITVProgramAdmin adminService = new TVProgramAdmin(TVProgData);			
			Naming.rebind(nameAdmin, adminService);
			System.out.println("* TVProgram Admin Service '" + nameAdmin + "' active and waiting...");
			
			ITVProgramReceiver receiverService = new TVProgramReceiver(TVProgData, args[0], args[1], args[2], args[3]);
			Naming.rebind(nameReceiver, receiverService);
			System.out.println("* TVProgram Receiver Service '" + nameReceiver + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ TVProgramManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
