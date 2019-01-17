package es.deustoair.dao;

import java.rmi.RemoteException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;

public class DeustoAirDAO implements IDeustoAirDAO{
	private static final long serialVersionUID = 1L;
	private PersistenceManagerFactory pmf = null;
	
	public DeustoAirDAO() throws RemoteException{
		
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
	}
	public User getUser(String emailUser) throws RemoteException {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		User usr = null;
	    
		try {
			System.out.println ("   * Querying a User: " + emailUser);
			
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

	public void storeReservation(User usr) throws RemoteException {
		this.storeObject(usr);
		
	}
	
	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    User usr = (User) object;
	    
	    try {
	       tx.begin();
	       System.out.println("   * Storing an User: " + usr.getEmail());
	       
	       pm.makePersistent(usr);
	       System.out.println("D1");
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
