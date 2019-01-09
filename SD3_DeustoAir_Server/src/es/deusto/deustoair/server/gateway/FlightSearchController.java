package es.deusto.deustoair.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;

import es.deusto.deustoair.db.DeustoAirDatabase;
import es.deusto.deustoair.server.data.Airport;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.dto.AirportDTO;

public class FlightSearchController {
	
	private String ip;
	private String port;
	private Socket socket;
	
	public FlightSearchController(){
		this.ip = "127.0.0.1";
		this.port = "35601";
	}
	
	public Flight[] searchFlights(Airport origin, Airport destination, String dDate, String rDate, int seats) {
		String request = origin.getCode() + ";" +  destination.getCode() + ";" + dDate  + ";" + rDate + ";" + seats;
		System.out.println(request);

		Flight[] result = null;
		try {
			System.out.println(ip + ":" + port);
			socket = new Socket(ip, Integer.parseInt(port));
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(request);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String inData = in.readUTF();
			result = new Flight[inData.split("#").length];
			String fltStr[] = inData.split("#");
			for(int i = 0; i < fltStr.length; i++) {
				String params[] = fltStr[i].split(";");
				result[i] = new Flight(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]),
						new Date(Long.parseLong(params[4])), Integer.parseInt(params[5]), DeustoAirDatabase.getAirport(params[6]),
						DeustoAirDatabase.getAirport(params[7]), Integer.parseInt(params[8]));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
