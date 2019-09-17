package com.example.CouponProjectCore.customerDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CouponProjectCore.entity.CustomerCoupons;

public interface CustomerCouponDAO extends JpaRepository<CustomerCoupons, Integer> {}
