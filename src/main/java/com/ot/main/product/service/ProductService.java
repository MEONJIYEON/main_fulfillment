package com.ot.main.product.service;

import java.util.List;

import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;
import com.ot.main.product.data.dto.ProductSearchCodeOrNameResponseDto;
import com.ot.main.product.data.dto.ProductSelectAllResponseDto;
import com.ot.main.product.data.dto.ProductUpdateRequestDto;
import com.ot.main.product.data.dto.ProductUpdateResponseDto;

public interface ProductService  {
	ProductUpdateResponseDto updateProduct(ProductUpdateRequestDto productUpdateRequestDto) throws Exception;
	List<ProductSelectAllResponseDto> seletcAllProduct();
	ProductCreateResponseDto saveProduct(ProductCreateRequestDto productCreateRequestDto);
	
	void deleteProduct(String productCode) throws Exception;
	
	List<ProductSearchCodeOrNameResponseDto> searchProductCodeOrName(String searchKeyword);
	List<ProductSearchCodeOrNameResponseDto> searchProductCode(String searchKeyword);
	List<ProductSearchCodeOrNameResponseDto> searchName(String searchKeyword);
}
