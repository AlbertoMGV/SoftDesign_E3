package es.deusto.deustoair.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class GoogleLoginHelper implements IAuthGateway{
	
	private String ip;
	private String port;
	private Socket socket;
	private String email, password;
	
	public GoogleLoginHelper(String email, String password) {
		this.email = email;
		this.password = password;
		this.ip = "127.0.0.1";
		this.port = "35600";
	}

	@Override
	public boolean login() {
		String text = email + ";" + password;
		boolean result = false;
		try {
			System.out.println(ip+":"+port);
			socket = new Socket(this.ip, Integer.parseInt(this.port));
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(text);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			result = Boolean.parseBoolean(in.readUTF());
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
