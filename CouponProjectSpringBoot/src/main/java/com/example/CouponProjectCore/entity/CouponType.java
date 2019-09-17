package com.example.CouponProjectCore.entity;

public enum CouponType {
	
	SPORTS ("Sports"),
	GAMES ("Games"),
	FASHION ("Fashion");

	public final String couponType;
	
	CouponType(String couponType){
		this.couponType=couponType;
	}

	public String getCouponType() {
		return couponType;
	}
	
	
	
}
