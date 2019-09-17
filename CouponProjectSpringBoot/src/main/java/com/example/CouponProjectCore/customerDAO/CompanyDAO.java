package com.example.CouponProjectCore.customerDAO;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CouponProjectCore.entity.Company;
import com.example.CouponProjectCore.entity.Coupon;
import com.example.CouponProjectCore.entity.CouponType;
import com.example.CouponProjectCore.entity.Customer;

public interface CompanyDAO extends JpaRepository<Company, Integer>{
	


}
