package com.example.CouponProjectCore.customerService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CouponProjectCore.customerDAO.CompanyDAO;
import com.example.CouponProjectCore.customerDAO.CouponDAO;
import com.example.CouponProjectCore.entity.Company;
import com.example.CouponProjectCore.entity.Coupon;
import com.example.CouponProjectCore.entity.CouponType;

@Service
public class CouponService implements CouponDAO {

	private CouponDAO couponDAO;

	@Autowired
	public CouponService(CouponDAO couponDAO) {
		System.out.println("inside couponDAO const");
		this.couponDAO = couponDAO;
	}

	@Override
	public List<Coupon> findAll() {
	return	couponDAO.findAll();
	}

	@Override
	public List<Coupon> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Coupon> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Coupon> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Coupon> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Coupon getOne(Integer id) {
		// TODO Auto-generated method stub
		return couponDAO.getOne(id);
	}

	@Override
	public <S extends Coupon> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Coupon> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Coupon> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Coupon> S save(S entity) {
		System.out.println("saving coupon");

		return couponDAO.save(entity);

	}

	@Override
	public Optional<Coupon> findById(Integer id) {
		return couponDAO.findById(id);
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
	couponDAO.deleteById(id);

	}

	@Override
	public void delete(Coupon entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Coupon> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Coupon> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Coupon> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Coupon> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Coupon> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
