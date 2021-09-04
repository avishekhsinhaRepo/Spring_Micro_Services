package com.springcloud.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.coupon.model.Coupon;
import com.springcloud.coupon.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo couponRepo;
	
	@RequestMapping(method = RequestMethod.POST, value = "/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}
	
	@RequestMapping(value = "/coupons/{code}" , method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponRepo.findByCode(code);
	}
}
