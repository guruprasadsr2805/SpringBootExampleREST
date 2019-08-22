package com.example.restservices.Hello;

public class UserDetails {
	
	private String firstName;
	private String lastname;
	private String city;
	
	//Fields Constructor
	public UserDetails(String firstName, String lastname, String city) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.city = city;
	}
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//ToString method
	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastname=" + lastname + ", city=" + city + "]";
	}

}
