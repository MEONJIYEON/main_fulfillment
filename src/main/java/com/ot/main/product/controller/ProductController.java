package com.ot.main.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;
import com.ot.main.product.data.dto.ProductSearchCodeOrNameResponseDto;
import com.ot.main.product.data.dto.ProductSelectAllResponseDto;
import com.ot.main.product.data.dto.ProductUpdateRequestDto;
import com.ot.main.product.data.dto.ProductUpdateResponseDto;

public interface ProductController {
	ResponseEntity<List<ProductSelectAllResponseDto>> seletcAllProduct();
	ResponseEntity<ProductCreateResponseDto> saveProduct(ProductCreateRequestDto productCreateRequestDto);
	ResponseEntity<ProductUpdateResponseDto> updateProduct(ProductUpdateRequestDto productUpdateRequestDto) throws Exception;
	ResponseEntity<String>  deleteProduct(String productCode) throws Exception;
	
	ResponseEntity<List<ProductSearchCodeOrNameResponseDto>> searchProduct(@RequestParam String searchKeyword,@RequestParam Integer searchType);

}
