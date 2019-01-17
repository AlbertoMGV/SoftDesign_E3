package es.deusto.deustoair.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.PortableServer.IdUniquenessPolicyOperations;

import es.deusto.deustoair.server.data.Airport;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.FlightBooking;
import es.deusto.deustoair.server.data.Reservation;
import es.deusto.deustoair.server.data.User;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.remote.DeustoAirServerRemote;
import es.deusto.deustoair.server.remote.IDeustoAirServerRemote;
import es.deustoair.dao.DeustoAirDAO;
import es.deustoair.dao.IDeustoAirDAO;


public class DeustoAirServer {
	

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		
		String serverName = "//" + args[0] + ":" + args[1] + "/" + args[2];
		
		
		
		
		try {
			DeustoAirService service = new DeustoAirService();
			IDeustoAirServerRemote serverRemote = new DeustoAirServerRemote(service);			
			Naming.rebind(serverName, serverRemote);
			
			System.out.println("* Server is now running: "+serverName);
			
			System.out.println("---------------------");			
			IDeustoAirDAO dstdao = new DeustoAirDAO();
			
			System.out.println("* Creating 3 Users...");
			
			User usr = new User(0, "pedro@deusto.es", "paypal", new Airport("BIO"));
			User usr1 = new User(1, "luis@deusto.es", "credit", new Airport("MAD"));
			User usr2 = new User(2, "juan@deusto.es", "credit", new Airport("BIO"));
			
			System.out.println("* Creating 4 Reservations...");
			
			FlightBooking[] bookedFlights = null;
			Reservation r1 = new Reservation(0, new Date(System.currentTimeMillis()), 21, bookedFlights, usr, 100);
			Reservation r2 = new Reservation(1, new Date(System.currentTimeMillis()), 12, bookedFlights, usr1, 52);
			Reservation r3 = new Reservation(2, new Date(System.currentTimeMillis()), 52, bookedFlights, usr2, 65);
			Reservation r4 = new Reservation(3, new Date(System.currentTimeMillis()), 10, bookedFlights, usr2, 210);
			
			System.out.println("* Adding to users...");
			
			usr.addReservation(r1);
			usr1.addReservation(r2);
			usr2.addReservation(r3);
			usr2.addReservation(r4);
			
			System.out.println("* Storing 3 Users..");
			
			dstdao.storeReservation(usr);
			dstdao.storeReservation(usr1);
			dstdao.storeReservation(usr2);
			
			System.out.println("* Getting all the users from the DB..");
			
			List<User> usrs = dstdao.getUsers();
			System.out.println("");
			System.out.println(" * List of Clients and Reservations");
			for (User user : usrs) {
				System.out.println("Client ID: "+user.getId()+" Client email: "+user.getEmail()+" Client Airport: "+user.getDefaultAirport()+" Client PayMethod: "+user.getPreferredPaymentMethod());
				System.out.println("Reservations");
				for (Reservation rvs : user.getReservations()) {
					System.out.println("ID:"+rvs.getId()+" Price:"+rvs.getPrice()+" UserEmail: "+rvs.getBookedBy().getEmail());
				}
			}
			
			/*
			System.out.println("* Main DeustoAir Server now running on: '" + serverName);
			AirportDTO bio = new AirportDTO("BIO", "Loiu Airport", "Bilbao", "Spain");
			AirportDTO mad = new AirportDTO("MAD", "Adolfo Suarez Airport", "Madrid", "Spain");
			FlightDTO[] flts = serverRemote.searchFlights(bio, mad, "08/01/2019", "14/01/2019", 1);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			for(int i = 0; i < flts.length; i++) {
				System.out.println(flts[i] . getFltNumber() + ": " + format.format(flts[i].getDepartureDateTime()));
			}*/
			//serverRemote.register("test@gmail.com", "test", "google", bio);
			//System.out.println("login test: " + serverRemote.login("test@gmail.com", "test", "google"));

		} catch (Exception e) {
			System.err.println("$ DeustoAir exception: " + e.getMessage());
			e.printStackTrace();
		}
	}


}
