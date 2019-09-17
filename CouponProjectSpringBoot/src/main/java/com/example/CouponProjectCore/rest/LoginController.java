package com.example.CouponProjectCore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CouponProjectCore.customerService.CompanyService;
import com.example.CouponProjectCore.customerService.CustomerService;

@Controller
public class LoginController {
	
	CompanyService companyService;
	CustomerService customerService;
	
	
	@Autowired
	public LoginController(CompanyService companyService,CustomerService customerService) {
		this.companyService = companyService;
		this.customerService = customerService;	
	}

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
	
		return "plain-login";
	}	
	

	@GetMapping("/")
	public String showHome(@AuthenticationPrincipal User user) {
		
		System.out.println(user.getAuthorities().toString());
		if (user.getAuthorities().toString().contains("ADMIN")) {
			System.out.println("in admin");
		}
		if (user.getAuthorities().toString().contains("COMPANY")) {
			System.out.println("in company");
			companyService.findAndSetCurrentCompany(user);
			
		}
		if (user.getAuthorities().toString().contains("CUSTOMER")) {
			customerService.findAndSetCurrentCustomer(user);
			System.out.println("in customer");
		}	
	
		return "home";
	}
}
