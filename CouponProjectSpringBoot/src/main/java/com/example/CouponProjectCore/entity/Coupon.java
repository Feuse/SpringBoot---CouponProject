package com.example.CouponProjectCore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupid")
	private Integer coupid;
	@Column(name = "title")
	private String title;
	@Column(name = "startd")
	private String startd;
	@Column(name = "endd")
	private String endd;
	@Column(name = "amount")
	private int amount;
	@Column(name = "type")
	private String type;
	@Column(name = "message")
	private String message;
	@Column(name = "price")
	private double price;
	@Column(name = "image")
	private String image;

	@ManyToOne()
	private Company company;
	

	
	public Coupon() {
	}

	
	

	public Coupon(String title, String startd, String endd, int amount, String type, String message, double price,
			String image, Company company) {
		super();
		this.title = title;
		this.startd = startd;
		this.endd = endd;
		this.amount = amount;
		this.type = type;
		this.message = message;
		this.price = price;
		this.image = image;
		this.company = company;
	}






	public Integer getCoupid() {
		return coupid;
	}

	public void setCoupid(Integer coupid) {
		this.coupid = coupid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartd() {
		return startd;
	}

	public void setStartd(String startd) {
		this.startd = startd;
	}

	public String getEndd() {
		return endd;
	}

	public void setEndd(String endd) {
		this.endd = endd;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Coupon [coupid=" + coupid + ", title=" + title + ", startd=" + startd + ", endd=" + endd + ", amount="
				+ amount + ", type=" + type + ", message=" + message + ", price=" + price + ", image=" + image
				+ ", company=" + company +"]";
	}






}