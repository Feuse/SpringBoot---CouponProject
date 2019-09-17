package com.example.CouponProjectCore.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int cust_id;
	
	@Size(min=1,message="is required")
	private String cust_name;
	
	@Size(min = 1, message = "is required")
	private String password;
	
//	   @ManyToMany
//	   @JoinTable(
//	   name="customer_coupons",
//	   joinColumns=@JoinColumn(name="customerId", referencedColumnName="cust_id"),
//	   inverseJoinColumns=@JoinColumn(name="couponId", referencedColumnName="coupid"))
//	private List<Coupon> coupons;

	@Enumerated(EnumType.STRING)
	private ClientType client_type = ClientType.CUSTOMER;
	
	public Customer() {
		
	}



	public Customer(String cust_name,String password, ClientType client_type) {
		super();
		this.cust_name = cust_name;
		this.password = password;

		this.client_type = client_type;
	}



	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
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
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", password=" + password 
				 + ", client_type=" + client_type + "]";
	}

	

}
