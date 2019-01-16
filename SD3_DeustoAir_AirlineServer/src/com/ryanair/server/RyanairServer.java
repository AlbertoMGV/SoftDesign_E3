package com.ryanair.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.ryanair.data.FlightsDatabase;


public class RyanairServer {
	
private static int numClients = 0;
	
	public static void main(String args[]) {
		System.out.println(args.length);
		if (args.length < 1) {
			System.err.println(" # Usage: RyanairServer [PORT]");
			System.exit(1);
		}
		
		int serverPort = Integer.parseInt(args[0]);
		
		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - RyanairServer: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");
			while (true) {
				new RyanairService(tcpServerSocket.accept());
				System.out.println(" - RyanairServer: New client connection accepted. Client number: " + ++numClients);
			}
		} catch (IOException e) {
			System.err.println("# RyanairServer: IO error:" + e.getMessage());
		}
	}

}
