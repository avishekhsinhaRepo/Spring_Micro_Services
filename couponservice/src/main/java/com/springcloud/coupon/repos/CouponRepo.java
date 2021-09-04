package com.springcloud.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.coupon.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
