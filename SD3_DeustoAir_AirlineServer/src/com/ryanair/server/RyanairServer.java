package com.ryanair.server;

import java.io.IOException;
import java.net.ServerSocket;


public class RyanairServer {
	
private static int numClients = 0;
	
	public static void main(String args[]) {
		System.out.println(args.length);
		if (args.length < 1) {
			System.err.println(" # Usage: AuthServer [PORT]");
			System.exit(1);
		}
		
		int serverPort = Integer.parseInt(args[0]);
		
		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - AuthServer: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");
			
			while (true) {
				new RyanairService(tcpServerSocket.accept());
				System.out.println(" - AuthServer: New client connection accepted. Client number: " + ++numClients);
			}
		} catch (IOException e) {
			System.err.println("# AuthServer: IO error:" + e.getMessage());
		}
	}

}
