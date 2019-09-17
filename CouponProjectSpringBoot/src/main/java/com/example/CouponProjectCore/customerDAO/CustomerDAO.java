package com.example.CouponProjectCore.customerDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import com.example.CouponProjectCore.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{


}
