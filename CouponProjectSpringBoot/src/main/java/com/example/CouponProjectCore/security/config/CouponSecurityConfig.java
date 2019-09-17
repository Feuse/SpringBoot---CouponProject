package com.example.CouponProjectCore.security.config;



import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import com.example.CouponProjectCore.customerService.CompanyService;
import com.example.CouponProjectCore.customerService.CustomerService;
import com.example.CouponProjectCore.customerService.TheUserService;
import com.example.CouponProjectCore.entity.ClientType;
import com.example.CouponProjectCore.entity.Company;
import com.example.CouponProjectCore.entity.Customer;
import com.example.CouponProjectCore.entity.TheUser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class CouponSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private CustomerService customerservice;
	private CompanyService companyservice;
	private TheUserService userService;
	
	  @Autowired
	    public CouponSecurityConfig(CustomerService customerservice,CompanyService companyservice,TheUserService userService) {
	        super();
	        System.out.println("CouponSecurityConfig const");
	        this.customerservice = customerservice;
	        this.companyservice = companyservice;
	        this.userService = userService;
	    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.out.println("security config");
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		List<Customer> custList = customerservice.findAll();
		List<Company> compList = companyservice.findAll();
		List<TheUser> userList = userService.findAll();

		for (Customer customer : custList) {
			auth.inMemoryAuthentication()
			.withUser(users.username(customer.getCust_name()).password(customer.getPassword()).roles("CUSTOMER"));
		System.out.println(customer);
		}
		for (Company company : compList) {
			auth.inMemoryAuthentication()
			.withUser(users.username(company.getComp_name()).password(company.getPassword()).roles("COMPANY"));
		}
		for (TheUser currUser : userList) {
			auth.inMemoryAuthentication()
			.withUser(users.username(currUser.getName()).password(currUser.getPassword()).roles("ADMIN"));
		
			
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
//		.antMatchers("/AdminView/**").hasRole("ADMIN")
		.antMatchers("/**").hasAnyRole("ADMIN","CUSTOMER","COMPANY")
//		.antMatchers("/CustomerView/**").hasRole("CUSTOMER")
//		.antMatchers("/CompanyView/**").hasRole("COMPANY")
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout().permitAll();	
	}
}