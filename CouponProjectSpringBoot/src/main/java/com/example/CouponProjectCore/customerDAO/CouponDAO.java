package com.example.CouponProjectCore.customerDAO;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CouponProjectCore.entity.Coupon;
import com.example.CouponProjectCore.entity.CouponType;
import com.example.CouponProjectCore.entity.Customer;


public interface CouponDAO extends JpaRepository<Coupon, Integer>{
	


}
