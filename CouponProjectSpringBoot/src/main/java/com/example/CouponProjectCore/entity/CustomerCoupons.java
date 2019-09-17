package com.example.CouponProjectCore.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "customer_coupons")
public class CustomerCoupons {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "coupon_id")
	private int couponId;
	@Column(name = "customer_id")
	private int customerId;

	public CustomerCoupons() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerCoupons(int couponId, int customerId) {
		super();
		this.couponId = couponId;
		this.customerId = customerId;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "CustomerCoupons [id=" + id + ", couponId=" + couponId + ", customerId=" + customerId + "]";
	}
	
	

}
