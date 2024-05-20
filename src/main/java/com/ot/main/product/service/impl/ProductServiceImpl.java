package com.ot.main.product.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.main.product.data.dao.ProductDAO;
import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;
import com.ot.main.product.data.entity.Product;
import com.ot.main.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	// 상품 생성
	@Override
	public ProductCreateResponseDto saveProduct(ProductCreateRequestDto productCreateRequestDto) {
		Product product = new Product();
		product.setProductCode(productCreateRequestDto.getProductCode());
		product.setName(productCreateRequestDto.getName());
		product.setProductStock(productCreateRequestDto.getProductStock());
		product.setSafetyStock(productCreateRequestDto.getSafetyStock());
		product.setLeadTime(productCreateRequestDto.getLeadTime());
		product.setCreate_at(LocalDateTime.now());
		product.setUpdated_at(LocalDateTime.now());
		
		Product savedProduct = productDAO.insertProduct(product);
		
		ProductCreateResponseDto productCreateResponseDto = new ProductCreateResponseDto();
		
		productCreateResponseDto.setProductCode(savedProduct.getProductCode());
		productCreateResponseDto.setName(savedProduct.getName());
		productCreateResponseDto.setProductStock(savedProduct.getProductStock());
		productCreateResponseDto.setSafetyStock(savedProduct.getSafetyStock());
		productCreateResponseDto.setLeadTime(savedProduct.getLeadTime());
		productCreateResponseDto.setCreate_at(savedProduct.getCreate_at());
		productCreateResponseDto.setUpdated_at(savedProduct.getUpdated_at());
		
		return productCreateResponseDto;
	}
	
	

}
