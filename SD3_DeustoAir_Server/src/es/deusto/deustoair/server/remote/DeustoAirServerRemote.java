package es.deusto.deustoair.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.deustoair.server.DeustoAirService;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.data.dto.PaymentDTO;
import es.deusto.deustoair.server.data.dto.ReservationDTO;
import es.deusto.deustoair.server.data.dto.UserDTO;

public class DeustoAirServerRemote extends UnicastRemoteObject implements IDeustoAirServerRemote {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DeustoAirService service;
	private PersistenceManagerFactory pmf;
	
	public DeustoAirServerRemote(DeustoAirService service) throws RemoteException{
		this.service = service;
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	@Override
	public boolean register(String username, String password, String authMethod, AirportDTO defaultAirport) throws RemoteException {
		return service.register(username, password, authMethod, "paypal", defaultAirport);
	}
	@Override
	public boolean login(String username, String password, String authMethod) throws RemoteException {
		return service.login(username, password, authMethod, false);
	}
	@Override
	public FlightDTO[] searchFlights(AirportDTO origin, AirportDTO destination, String dDate, String rDate, int seats) throws RemoteException {
		return service.searchFlights(origin, destination, dDate, rDate, seats);
	}
	@Override
	public boolean orderFlight(FlightDTO flight, int seats, UserDTO user) throws RemoteException {
		return service.orderFlight(flight, seats, user);
	}
	@Override
	public PaymentDTO pay(ReservationDTO res, String args, String type) throws RemoteException {
		return service.pay(res, args, type);
	}

	@Override
	public User getUser(String emailUser) throws RemoteException {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		User usr = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + emailUser);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE name == '" + emailUser + "'");
	    	query.setUnique(true);
	    	usr = (User)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return usr;
	}

	@Override
	public Flight getFlight(String codeFlight) throws RemoteException {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Flight flg = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + codeFlight);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + Flight.class.getName() + " WHERE code == '" + codeFlight + "'");
	    	query.setUnique(true);
	    	flg = (Flight)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return flg;
		
	}

	@Override
	public void storeReservation(User usr) throws RemoteException {
		this.storeObject(usr);
		
	}
	
	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an User: " + object);
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing the user: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}

}
