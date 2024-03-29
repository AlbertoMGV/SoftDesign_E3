package es.deusto.deustoair.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Airport {

	@PrimaryKey
	private String code;
	private String name;
	private String city;
	private String country;
	
	public Airport(String code) {
		this.code = code;
		this.name = "";
		this.city = "";
		this.country = "";
	}
	
	public Airport(String code, String name, String city, String country) {
		super();
		this.code = code;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
