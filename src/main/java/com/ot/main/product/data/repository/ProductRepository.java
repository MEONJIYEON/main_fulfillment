package com.ot.main.product.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.main.product.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
