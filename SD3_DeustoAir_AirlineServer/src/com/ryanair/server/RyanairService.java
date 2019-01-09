package com.ryanair.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

import com.ryanair.data.Flight;
import com.ryanair.data.FlightsDatabase;

public class RyanairService extends Thread{


	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private FlightsDatabase fDb;
	
	public RyanairService(Socket socket) {
		try {
			this.tcpSocket = socket;
			this.fDb = new FlightsDatabase();
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# RyanairService - TCPConnection IO error:" + e.getMessage());
		}	
	}
	

	
	public void run() {
		try {
			String data[] = this.in.readUTF().split(";");
			String origin = data[0];
			String destination = data[1];
			String dDate = data[2];
			String rDate = data[3];
			int seats = Integer.parseInt(data[4]);
			System.out.println("   - RyanairService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + Arrays.toString(data) + "'");					
			Flight[] resultArr = fDb.searchFlights(origin, destination, dDate, rDate, seats);
			String result = "";
			for(int i = 0; i < resultArr.length; i++) {
				result = result + resultArr[i].toString() + "#";
			}
			result = result.substring(0, result.length() - 1);
			this.out.writeUTF(result+"");					
			System.out.println("   - RyanairService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + result + "'");
		} catch (EOFException e) {
			System.err.println("   # RyanairService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # RyanairService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # RyanairService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}

}
