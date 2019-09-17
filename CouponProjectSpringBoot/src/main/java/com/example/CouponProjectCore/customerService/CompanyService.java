package com.example.CouponProjectCore.customerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.CouponProjectCore.customerDAO.CompanyDAO;
import com.example.CouponProjectCore.customerDAO.CustomerDAO;
import com.example.CouponProjectCore.entity.Company;
import com.example.CouponProjectCore.entity.Coupon;
import com.example.CouponProjectCore.entity.CouponType;

@Service
public class CompanyService implements CompanyDAO {

	private CompanyDAO companyDAO;
	private Company currentCompany;
	private CouponService couponService;

	
	@Autowired
	public CompanyService(CompanyDAO companyDAO,CouponService couponService,HttpSession session) {
		this.couponService = couponService;
		this.companyDAO = companyDAO;
	}
	
	public Company getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(Company currentCompany) {
		this.currentCompany = currentCompany;
	}

		
	public void findAndSetCurrentCompany(User user) {

		List<Company> companies = findAll();

		for (Company company : companies) {
			if (company.getComp_name().contentEquals(user.getUsername())) {
				
				//System.out.println(company.getCoupons());
				setCurrentCompany(company);
			
				//System.out.println(company.toString());
			}
		}
	}
	


	@Override
	public List<Company> findAll() {

		return companyDAO.findAll();
	}

	@Override
	public List<Company> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Company> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Company> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getOne(Integer id) {
		return companyDAO.getOne(id);
	}

	@Override
	public <S extends Company> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Company> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> S save(S entity) {

		return companyDAO.save(entity);
	}

	@Override
	public Optional<Company> findById(Integer id) {
		return companyDAO.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
	companyDAO.deleteById(id);

	}

	@Override
	public void delete(Company entity) {
		companyDAO.delete(entity);

	}

	@Override
	public void deleteAll(Iterable<? extends Company> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		companyDAO.deleteAll();

	}

	@Override
	public <S extends Company> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Company> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
