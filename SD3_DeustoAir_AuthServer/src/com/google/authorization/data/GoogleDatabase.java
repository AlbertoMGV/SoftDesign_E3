package com.google.authorization.data;

import java.util.HashMap;

public class GoogleDatabase {
	
	private HashMap<String, User> users;
	
	public GoogleDatabase() {
		users = new HashMap<String, User>();
		User u1 = new User("test@gmail.com", "test");
		User u2 = new User("admin@gmail.com", "admin");
		users.put(u1.getEmail(), u1);
		users.put(u2.getEmail(), u1);
	}
	
	public boolean login(String email, String password) {
		return users.get(email).getPassword().equals(password);
	}	

}
