package com.example.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Every instance of an entity represent a row in the table
@Entity//(name="user")
@Table(name="user")//this will create a table called user in the DB. If we do not give any name attribute
				  //class name will be used as table name
public class User {

	@Id //Means this is the primary key
	@GeneratedValue //Auto generates the value for Id field
	private long id;
	
	@Column(name="user_name",length=50,nullable = false,unique = true)
	private String username;
	
	@Column(name="first_name",length=50,nullable = false)
	private String firstname;
	
	@Column(name="last_name",length=50,nullable = false)
	private String lastname;
	
	@Column(name="email_id",length=50,nullable = false,unique = true)
	private String email;
	
	@Column(name="role",length=50,nullable = false)
	private String role;
	
	@Column(name="ssn",length=50,nullable = false,unique = true)
	private String ssn;
	
	
	//No Arguments constructor
	public User() {
	}
	
	//Fields Constructors
	public User(long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	//To String method
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}

	//Getters and setters for the fields
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}	
}