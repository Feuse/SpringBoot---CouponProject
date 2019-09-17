package com.example.CouponProjectCore.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.CouponProjectCore.customerService.CompanyService;
import com.example.CouponProjectCore.customerService.CouponService;
import com.example.CouponProjectCore.entity.Coupon;

@Controller
@RequestMapping("/company")
public class CompanyController {

	CouponService couponService;
	CompanyService companyService;
	HttpSession session;

	public CompanyController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public CompanyController(CouponService couponService, CompanyService companyService) {
		this.couponService = couponService;
		this.companyService = companyService;
	}

	@PostMapping("/create")
	public String createCoupon(@ModelAttribute("theCoupon") Coupon theCoupon, Model theModel) {
	
			// problem with ToString of company, check why ?

			theCoupon.setCoupid(0);
			theCoupon.setCompany(companyService.getCurrentCompany());
			// System.out.println(companyService.getCurrentCompany().toString());
			couponService.save(theCoupon);

//		theModel.addAttribute("theCoupon", theCoupon);

			return "savedCoupon";
	
	}

	@GetMapping("/read")
	public String getAllCoupons(Model theModel) {

		List<Coupon> coupon = new ArrayList<Coupon>();
		List<Coupon> theCoupons = couponService.findAll();
		if (theCoupons.size() != 0) {
			for (Coupon theCoupon : theCoupons) {
				System.out.println(theCoupons.size());
				System.out.println("couponCOMPid: " + theCoupon.getCompany().getId());
				System.out.println("currcompID" + companyService.getCurrentCompany().getId());
				if (companyService.getCurrentCompany().getId() == theCoupon.getCompany().getId()) {
					System.out.println("adding");
					coupon.add(theCoupon);
					theModel.addAttribute("theCoupon", coupon);
				}
			}
		}

		return "showAllCoupons";
	}

	@PostMapping("company/update")
	public String updateCoupon(@ModelAttribute("theCoupon") Coupon theCoupon, Model theModel) {

		theCoupon.setCompany(companyService.getCurrentCompany());
		couponService.save(theCoupon);
		theModel.addAttribute("theCoupon", theCoupon);

		return "updatedCoupon";
	}

	@GetMapping("delete/{coupid}")
	public String removeCoupon(@PathVariable int coupid, Model model) {

		couponService.deleteById(coupid);

		return "redirect:/company/read";
	}

}
