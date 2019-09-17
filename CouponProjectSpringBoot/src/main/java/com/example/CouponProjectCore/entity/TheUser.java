package com.example.CouponProjectCore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class TheUser {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="client_type")
	@Enumerated(EnumType.STRING)
	private ClientType client_type = ClientType.ADMIN;

	public TheUser(int id,String name, String password, ClientType client_type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.client_type = client_type;
	}
	
	public TheUser() {
		
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ClientType getClient_type() {
		return client_type;
	}
	public void setClient_type(ClientType client_type) {
		this.client_type = client_type;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", client_type=" + client_type + "]";
	}
	
}

