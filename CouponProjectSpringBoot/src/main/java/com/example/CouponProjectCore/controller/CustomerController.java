package com.example.CouponProjectCore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CouponProjectCore.Services.CouponService;
import com.example.CouponProjectCore.Services.CustomerCouponDAOSecond;
import com.example.CouponProjectCore.Services.CustomerCouponService;
import com.example.CouponProjectCore.Services.CustomerService;
import com.example.CouponProjectCore.entity.Coupon;
import com.example.CouponProjectCore.entity.Customer;
import com.example.CouponProjectCore.entity.CustomerCoupons;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Controller

@RequestMapping("/customer")
public class CustomerController {

	CustomerService customerService;
	CouponService couponService;
	Customer customer;
	CustomerCoupons customerCoupons;
	CustomerCouponService customerCouponService;
	CustomerCouponDAOSecond customerCouponDAOImpl;

	@Autowired
	public CustomerController(CustomerService customerService, CouponService couponService,
			CustomerCouponService customerCouponService, CustomerCouponDAOSecond customerCouponDAOImpl) {
		this.customerService = customerService;
		this.couponService = couponService;
		this.customerCouponService = customerCouponService;
		this.customerCouponDAOImpl = customerCouponDAOImpl;

	}

	@IgnoreForBinding
	public List<Coupon> getAllCustomerCoupons() {

		List<CustomerCoupons> customerCouponIds = customerCouponDAOImpl.findAll();
		List<Coupon> allCoupons = couponService.findAll();
		List<Coupon> customerCoupon = new ArrayList<Coupon>();
		for (CustomerCoupons customerCoupons : customerCouponIds) {
			for (Coupon coupon : allCoupons) {
				if (customerCoupons.getCustomerId() == customerService.getCurrentCustomer().getCust_id()) {
					if (customerCoupons.getCouponId() == coupon.getCoupid()) {
						customerCoupon.add(coupon);
					}
				}
			}
		}
		return customerCoupon;
	}

	@GetMapping("purchase/{coupid}")
	public String purchaseCoupon(@PathVariable int coupid, Model model) {

			try {

				model.addAttribute("error", null);
				Coupon currentCoupon = couponService.getOne(coupid);

				if (!getAllCustomerCoupons().contains(currentCoupon)) {
					currentCoupon.setAmount(currentCoupon.getAmount() - 1);
					couponService.save(currentCoupon);
					Coupon coupon = couponService.getOne(coupid);
					int id = customerService.getCurrentCustomer().getCust_id();
					customerCouponService.save(id, coupid);
					model.addAttribute("coupon", coupon);
					return "PurchaseVerification";
				} else {
				model.addAttribute("error", "Unable to add duplicate coupon, please try a different one!");
					return "PurchaseVerification";
				}

			} catch (Exception ex) {
				model.addAttribute("error", "ERROR, Please show this message to support: " + ex.getMessage());
				return "PurchaseVerification";
			}
		
		
	}

	@GetMapping("/getAllCoupons")
	public String getAllCoupons(Model theModel) {

		System.out.println("IM HERE ");
		List<Coupon> theCoupons = couponService.findAll();
		theModel.addAttribute("theCoupon", theCoupons);

		return "home";

	}

	@GetMapping("/getAllPurchasedCoupons")
	public String getAllPurchasedCoupons(Model theModel) {

		if (!getAllCustomerCoupons().isEmpty()) {
			theModel.addAttribute("theCoupon", getAllCustomerCoupons());
		}
		return "getAllPurchasedCoupons";
	}
}
