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
import es.deusto.deustoair.server.data.Route;
import es.deusto.deustoair.server.data.User;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;
import es.deusto.deustoair.server.remote.DeustoAirServerRemote;
import es.deusto.deustoair.server.remote.IDeustoAirServerRemote;
import es.deustoair.dao.DeustoAirDAO;
import es.deustoair.dao.IDeustoAirDAO;


public class DeustoAirServer {
	

	@SuppressWarnings("null")
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
			
			User usr = new User(0, "pedro@deusto.es", "paypal", new Airport("AAA"));
			User usr1 = new User(1, "luis@deusto.es", "credit", new Airport("BBB"));
			User usr2 = new User(2, "juan@deusto.es", "credit", new Airport("CCC"));
			
			System.out.println("* Creating 4 Reservations...");
			
			System.out.println("     -Creating Airports...");
			Airport origin1 = new Airport("STD");
			Airport destination1 = new Airport("RUS");
			Airport origin2 = new Airport("GZ");
			Airport destination2 = new Airport("GIO");
			Airport origin3 = new Airport("REA");
			Airport destination3 = new Airport("QES");
			Airport origin4 = new Airport("BSD");
			Airport destination4 = new Airport("TSA");
			System.out.println("     -Creating Flights...");
			Flight a = new Flight(new Route("123", 1, 60, 350, origin1, destination1), new Date(System.currentTimeMillis()), 50);
			Flight b = new Flight(new Route("653", 2, 54, 350, origin2, destination2), new Date(System.currentTimeMillis()), 75);
			Flight c = new Flight(new Route("234", 3, 23, 350, origin3, destination3), new Date(System.currentTimeMillis()), 32);
			Flight d = new Flight(new Route("153", 4, 42, 350, origin4, destination4), new Date(System.currentTimeMillis()), 52);
			System.out.println("     -Creating FlightBooking...");
			FlightBooking a1 = new FlightBooking(a, new String[] {"23","24","25"}, new String[] {"Iñigo","Pedro","Luis"});
			FlightBooking a2 = new FlightBooking(b, new String[] {"1","2","3"}, new String[] {"Sara","Jon","Koala"});
			FlightBooking a3 = new FlightBooking(c, new String[] {"67","68","69"}, new String[] {"Juan","Ozuna","Ñengo"});
			FlightBooking a4 = new FlightBooking(d, new String[] {"13","14","15"}, new String[] {"Anuel","Omar","Montes"});
			System.out.println("     -Creating FlighBookingArray...");
			FlightBooking[] bookedFlights1 = {a1};
			FlightBooking[] bookedFlights2 = {a2};
			FlightBooking[] bookedFlights3 = {a3};
			FlightBooking[] bookedFlights4 = {a4};
			
			System.out.println("     -Creating...");
			
			Reservation r1 = new Reservation(0, new Date(System.currentTimeMillis()), 21, bookedFlights1, usr, 100);
			Reservation r2 = new Reservation(1, new Date(System.currentTimeMillis()), 12, bookedFlights2, usr1, 52);
			Reservation r3 = new Reservation(2, new Date(System.currentTimeMillis()), 52, bookedFlights3, usr2, 65);
			Reservation r4 = new Reservation(3, new Date(System.currentTimeMillis()), 10, bookedFlights4, usr2, 210);
			
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
			System.out.println(" * List of Clients");
			
			
			
			
			
			for (int i = usrs.size()-1; i >= 0; i--) {
				System.out.println("Client ID: "+usrs.get(i).getId()+" Client email: "+usrs.get(i).getEmail()+" Client PayMethod: "+usrs.get(i).getPreferredPaymentMethod());
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
