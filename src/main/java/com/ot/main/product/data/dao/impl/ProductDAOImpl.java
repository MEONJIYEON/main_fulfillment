package com.ot.main.product.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.main.product.data.dao.ProductDAO;
import com.ot.main.product.data.entity.Product;
import com.ot.main.product.data.repository.ProductRepository;

@Component
public class ProductDAOImpl implements ProductDAO {
	
	private ProductRepository productRepository;
	
	@Autowired 
	public ProductDAOImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		
		return savedProduct;
	}

}
