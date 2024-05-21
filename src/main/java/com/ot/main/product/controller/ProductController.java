package com.ot.main.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductSearchCodeOrNameResponseDto;
import com.ot.main.product.data.dto.ProductUpdateRequestDto;

public interface ProductController {
	//ResponseEntity<List<ProductSelectAllResponseDto>> seletcAllProduct();
	ModelAndView seletcAllProduct();
	
	//ResponseEntity<ProductCreateResponseDto> saveProduct(ProductCreateRequestDto productCreateRequestDto);
	ModelAndView saveProduct(@ModelAttribute ProductCreateRequestDto productCreateRequestDto);
	
	
	//ResponseEntity<ProductUpdateResponseDto> updateProduct(ProductUpdateRequestDto productUpdateRequestDto) throws Exception;
	ModelAndView updateProduct(@ModelAttribute ProductUpdateRequestDto productUpdateRequestDto) throws Exception;

	
	//ResponseEntity<String>  deleteProduct(String productCode) throws Exception;
	ModelAndView deleteProduct(String productCode) throws Exception;
	ResponseEntity<List<ProductSearchCodeOrNameResponseDto>> searchProduct(@RequestParam String searchKeyword,@RequestParam Integer searchType);

}
