package com.example.CouponProjectCore.rest;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.example.CouponProjectCore.customerService.CompanyService;
import com.example.CouponProjectCore.customerService.CustomerService;
import com.example.CouponProjectCore.entity.ClientType;
import com.example.CouponProjectCore.entity.Company;
import com.example.CouponProjectCore.entity.Customer;

import excpetions.CompanyNotFoundException;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	CompanyService companyService;
	CustomerService customerService;
	
	@Autowired
	public AdminController(CompanyService companyService,CustomerService customerService) {
		this.companyService = companyService;
		this.customerService = customerService;
	}
		
	@PostMapping("/createCompany")
	public String save(@ModelAttribute Company company,Model theModel) {
		
		company.setId(0);
		companyService.save(company);
     	theModel.addAttribute("company",company);
	
		return "savedCompany";
	}

	@GetMapping("/getAllCompanies")
	public String findAll(Model theModel) {
		List<Company> companies = companyService.findAll();	 
		theModel.addAttribute("companies", companies);
		return "showAllCompanies";
		
	}
	 
	@GetMapping("/getCompanyById/{id}")
	public String getCompanyById(@RequestParam int id, Model theModel){
		
		Optional<Company> company = companyService.findById(id);
		if (company.isPresent()) {
			
			theModel.addAttribute("company", company.get());
		}
	
		return "showOneCompany";
	}
	
	
	

	@ExceptionHandler 
	@GetMapping("/RemoveCompanyById/{id}")
	public String RemoveCompanyById(@PathVariable int id) {
		System.out.println(id);
		companyService.deleteById(id);
		
		
		return "redirect:/admin/getAllCompanies";
		
	}
	
	
	@PostMapping("/createCustomer")
	public String save(@ModelAttribute Customer customer, Model theModel) {
		customer.setCust_id(0);
		customer.setClient_type(ClientType.CUSTOMER);
		System.out.println(customer.toString());
		customerService.save(customer);
		theModel.addAttribute("customer", customer);
		return "saved";
	}
	
	@GetMapping("/getAllCustomers")
	public String getAllCustomers(Model theModel) {

		List<Customer> customers = customerService.findAll();
		theModel.addAttribute("customers", customers);
		return "show";
	}
	
	@GetMapping("/getCustomerById/{custid}")
	public String getCustomerById(@RequestParam int custid, Model theModel) {
		
		Optional<Customer> customer = customerService.findById(custid);
		theModel.addAttribute("customer", customer.get());
		
		
		return "oneCustomer";
		
	}
}
