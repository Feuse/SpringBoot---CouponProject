package com.example.CouponProjectCore.customerService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.CouponProjectCore.entity.CustomerCoupons;

@Service
public class CustomerCouponService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Integer custid, Integer coup) {
		CustomerCoupons custCoupons = new CustomerCoupons();
		custCoupons.setCustomerId(custid);
		custCoupons.setCouponId(coup);
		em.merge(custCoupons);
	}
}