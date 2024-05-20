package com.ot.main.product.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.main.product.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByProductCodeContainingOrNameContaining(String ProductCode, String name);
	List<Product> findByProductCodeContaining(String ProductCode);
	List<Product> findByNameContaining(String name);
	
	// 정렬 
	

}
