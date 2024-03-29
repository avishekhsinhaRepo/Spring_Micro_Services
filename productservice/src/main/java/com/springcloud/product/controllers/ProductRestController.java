package com.springcloud.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.product.model.Coupon;
import com.springcloud.product.model.Product;
import com.springcloud.product.repos.ProductRepo;
import com.springcloud.product.restclient.CouponClient;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CouponClient couponClient;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@Retry(name = "product-api" ,fallbackMethod = "handleError")
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepo.save(product);
	}
	
	public Product handleError(Product product, Exception exception) {
		System.out.println("Inside Handle Error");
		return product;
		
	}
}
