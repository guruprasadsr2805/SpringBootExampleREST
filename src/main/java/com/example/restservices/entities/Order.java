package com.example.restservices.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue
	private long orderid;
	private String orderdescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderid() {
		return orderid;
	}

	public String getOrderdescription() {
		return orderdescription;
	}

	public User getUser() {
		return user;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
