package com.ot.main.product.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot.main.product.controller.ProductController;
import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;
import com.ot.main.product.data.dto.ProductSearchCodeOrNameResponseDto;
import com.ot.main.product.data.dto.ProductSelectAllResponseDto;
import com.ot.main.product.data.dto.ProductUpdateRequestDto;
import com.ot.main.product.data.dto.ProductUpdateResponseDto;
import com.ot.main.product.service.ProductService;


@RestController
@RequestMapping("/api/v1/main-fulfillment/product")
public class ProductControllerImpl implements ProductController{
	private ProductService productService;
	
	@Autowired 
	public ProductControllerImpl(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	@GetMapping()
	public ResponseEntity<List<ProductSelectAllResponseDto>> seletcAllProduct() {
		List<ProductSelectAllResponseDto> productSelectAllResponseDtoList = productService.seletcAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(productSelectAllResponseDtoList);
		
	}
	

	@Override
	@PostMapping()
	public ResponseEntity<ProductCreateResponseDto> saveProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
		ProductCreateResponseDto productCreateResponseDto = productService.saveProduct(productCreateRequestDto);
		return ResponseEntity.status(HttpStatus.OK).body(productCreateResponseDto);
	}
	
	
	@Override
	@PutMapping()
	public ResponseEntity<ProductUpdateResponseDto> updateProduct(@RequestBody ProductUpdateRequestDto productUpdateRequestDto) throws Exception {
		ProductUpdateResponseDto productUpdateResponseDto = productService.updateProduct(productUpdateRequestDto);
		if(productUpdateResponseDto.getProductCode() == null || productUpdateResponseDto.getProductCode().isEmpty()) {
			// error templates 띄우기
			return ResponseEntity.status(HttpStatus.OK).body(productUpdateResponseDto);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(productUpdateResponseDto);
		}
		
	}
	
	@Override
	@DeleteMapping("/{productCode}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productCode) throws Exception {
		productService.deleteProduct(productCode);
		
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
	}

	
	@Override
	@GetMapping("/search")
	public ResponseEntity<List<ProductSearchCodeOrNameResponseDto>> searchProduct(@RequestParam String searchKeyword, @RequestParam Integer searchType) {
		List<ProductSearchCodeOrNameResponseDto> productSearchCodeOrNameResponseDtoList = new ArrayList<ProductSearchCodeOrNameResponseDto>();
		
		// 상품코드와 제목 검색 : 0 
		if(searchType.equals(0)) {
			productSearchCodeOrNameResponseDtoList = productService.searchProductCodeOrName(searchKeyword);
		} // 상품 코드만 검색 : 1
		else if(searchType.equals(1)) {
			productSearchCodeOrNameResponseDtoList = productService.searchProductCode(searchKeyword);
		} // 이름만 검색 : 2 
		else if(searchType.equals(2)) {
			productSearchCodeOrNameResponseDtoList =  productService.searchName(searchKeyword);
		}
		
	
		if (productSearchCodeOrNameResponseDtoList == null ||productSearchCodeOrNameResponseDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        } else {
        	return ResponseEntity.ok(productSearchCodeOrNameResponseDtoList); // 200 OK with products in the body
        }
	}
	
	
	
}
