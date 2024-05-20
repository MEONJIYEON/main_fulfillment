package com.ot.main.product.controller;

import org.springframework.http.ResponseEntity;

import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;

public interface ProductController {
	public void seletcAllProduct();
	public ResponseEntity<ProductCreateResponseDto> createProduct(ProductCreateRequestDto productCreateRequestDto);
	public void updateProduct();
	public void deleteProduct();
}
