package com.google.authorization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

import com.google.authorization.data.GoogleDatabase;

public class AuthService extends Thread{
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private GoogleDatabase gDb;
	
	public AuthService(Socket socket) {
		try {
			this.tcpSocket = socket;
			this.gDb = new GoogleDatabase();
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# AuthService - TCPConnection IO error:" + e.getMessage());
		}		
	}
	
	public void run() {
		try {
			String data[] = this.in.readUTF().split(";");
			String email = data[0];
			String pwd = data[1];
			System.out.println("   - AuthService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + Arrays.toString(data) + "'");					
			boolean result = gDb.login(email, pwd);
			this.out.writeUTF(result+"");					
			System.out.println("   - AuthService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + result + "'");
		} catch (EOFException e) {
			System.err.println("   # AuthService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # AuthService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # AuthService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}

}
