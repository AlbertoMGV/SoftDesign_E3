package es.deustoair.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.User;

public class DeustoAirDAO implements IDeustoAirDAO{
	private static final long serialVersionUID = 1L;
	private PersistenceManagerFactory pmf;
	
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
		this.storeUser(usr);
		
	}
	
	private void storeUser(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	       tx.begin();
	       System.out.println("   * Storing an User: " + user.getEmail());
	       
	       pm.makePersistent(user);
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
	public List<User> getUsers() throws RemoteException {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<User> users = new ArrayList<>();
		
		try {
			
			
			tx.begin();			
			Extent<User> extent = pm.getExtent(User.class, true);
			
			for (User usr: extent) {
				users.add(usr);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return users;
	}
	
}
