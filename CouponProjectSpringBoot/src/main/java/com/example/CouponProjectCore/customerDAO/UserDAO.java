package com.example.CouponProjectCore.customerDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.CouponProjectCore.entity.TheUser;

public interface UserDAO  extends JpaRepository<TheUser, Integer>{
	
	TheUser findUserByName(String name);
}
