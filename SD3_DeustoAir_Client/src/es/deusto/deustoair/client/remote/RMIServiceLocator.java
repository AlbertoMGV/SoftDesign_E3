package es.deusto.deustoair.client.remote;

import es.deusto.deustoair.server.remote.IDeustoAirServerRemote;

public class RMIServiceLocator {
	
	private IDeustoAirServerRemote airService;
	
	

    public RMIServiceLocator(){ 
    	
    }

    public void setService(String[] args) {
    	try {
	    	String nameAdm = "//" + args[0] + ":" + args[1] + "/" + args[2];
	    	System.out.println(nameAdm);
	    	airService = (IDeustoAirServerRemote) java.rmi.Naming.lookup(nameAdm);
    	} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    public IDeustoAirServerRemote getDeustoService() {
    	return this.airService;
    }
 
}
