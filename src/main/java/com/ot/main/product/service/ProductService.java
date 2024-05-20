package com.ot.main.product.service;

import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;

public interface ProductService  {
	public ProductCreateResponseDto saveProduct(ProductCreateRequestDto productCreateRequestDto);
}
