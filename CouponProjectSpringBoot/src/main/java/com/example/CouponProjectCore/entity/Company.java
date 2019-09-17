package com.example.CouponProjectCore.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "company")

public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "comp_name")
	private String comp_name;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;

	@OneToMany()
	@JoinColumn(name="company_id")
	private List<Coupon> coupons;

	@Column(name = "client_type")
	@Enumerated(EnumType.STRING)
	private ClientType client_type = ClientType.COMPANY;
	
	public Company() {

	}

	public Company(String comp_name, String password, String email, List<Coupon> coupons, ClientType client_type) {
		super();
		this.comp_name = comp_name;
		this.password = password;
		this.email = email;
		this.coupons = coupons;
		this.client_type = client_type;
		
	}

	public void addCoupon(Coupon coupon) {
		if (coupons == null) {
			coupons = new ArrayList<Coupon>();
		}

		coupons.add(coupon);
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public ClientType getClient_type() {
		return client_type;
	}

	public void setClient_type(ClientType client_type) {
		this.client_type = client_type;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", comp_name=" + comp_name + ", password=" + password + ", email=" + email
				+ ", coupons=" + coupons + ", client_type=" + client_type + "]";
	}


	
	



}
