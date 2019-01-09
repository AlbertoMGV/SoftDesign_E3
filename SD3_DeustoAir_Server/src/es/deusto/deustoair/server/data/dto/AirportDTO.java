package es.deusto.deustoair.server.data.dto;

import java.io.Serializable;

public class AirportDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private String city;
	private String country;
	
	public AirportDTO(String code, String name, String city, String country) {
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
