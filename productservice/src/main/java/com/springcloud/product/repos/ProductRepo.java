package com.springcloud.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.product.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
