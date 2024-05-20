package com.ot.main.product.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.main.product.controller.ProductController;
import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;
import com.ot.main.product.service.ProductService;


@RestController
@RequestMapping("/api/v1/main-fulfillment")
public class ProductControllerImpl implements ProductController{
	private ProductService productService;
	
	@Autowired 
	public ProductControllerImpl(ProductService productService) {
		this.productService = productService;
	}

	@Override
	@GetMapping("/product")
	public void seletcAllProduct() {
		
		
	}

	@Override
	@PostMapping("/product")
	public ResponseEntity<ProductCreateResponseDto> createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
		ProductCreateResponseDto productCreateResponseDto = productService.saveProduct(productCreateRequestDto);
		

		return ResponseEntity.status(HttpStatus.OK).body(productCreateResponseDto);
	}

	@Override
	@PutMapping("/product")
	public void updateProduct() {
		
		
	}

	@Override
	@DeleteMapping("/product")
	public void deleteProduct() {
		
		
	}
	
	
}
