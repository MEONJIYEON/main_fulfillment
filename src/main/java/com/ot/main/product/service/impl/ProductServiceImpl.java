package com.ot.main.product.service.impl;

import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.main.product.data.dao.ProductDAO;
import com.ot.main.product.data.dto.ProductCreateRequestDto;
import com.ot.main.product.data.dto.ProductCreateResponseDto;
import com.ot.main.product.data.dto.ProductSearchCodeOrNameResponseDto;
import com.ot.main.product.data.dto.ProductSelectAllResponseDto;
import com.ot.main.product.data.dto.ProductUpdateRequestDto;
import com.ot.main.product.data.dto.ProductUpdateResponseDto;
import com.ot.main.product.data.entity.Product;
import com.ot.main.product.service.ProductService;
import com.ot.main.productmanagement.data.dao.ProductManagementDAO;
import com.ot.main.productmanagement.data.dto.ProductManagementResponseDTO;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	// 전체 상품 조회
	@Override
	public List<ProductSelectAllResponseDto> seletcAllProduct() {
		List<Product> productList = productDAO.findAllProduct();
		
		List<ProductSelectAllResponseDto> productSelectAllResponseDtoList = productList.stream()
	            .map(product -> ProductSelectAllResponseDto.builder()
	                .productCode(product.getProductCode())
	                .safetyStock(product.getSafetyStock())
	                .name(product.getName())
	                .image(product.getImage())
	                .productStock(product.getProductStock())
	                .leadTime(product.getLeadTime())
	                .create_at(product.getCreate_at())
	                .build())
	            .collect(Collectors.toList());
		return productSelectAllResponseDtoList;
	}
	
	
	
	// 상품 생성
	@Override
	public ProductCreateResponseDto saveProduct(ProductCreateRequestDto productCreateRequestDto) {
		Product product = new Product();
		product.setProductCode(productCreateRequestDto.getProductCode());
		product.setName(productCreateRequestDto.getName());
		product.setImage(productCreateRequestDto.getImage());
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
		productCreateResponseDto.setImage(savedProduct.getImage());
		productCreateResponseDto.setSafetyStock(savedProduct.getSafetyStock());
		productCreateResponseDto.setLeadTime(savedProduct.getLeadTime());
		productCreateResponseDto.setCreate_at(savedProduct.getCreate_at());
		productCreateResponseDto.setUpdated_at(savedProduct.getUpdated_at());
		
		return productCreateResponseDto;
	}
	
	// 상품 업데이트 
	@Override
	public ProductUpdateResponseDto updateProduct(ProductUpdateRequestDto productUpdateRequestDto) throws Exception {
		Product product = Product.builder()
				.productCode(productUpdateRequestDto.getProductCode())
			    .name(productUpdateRequestDto.getName())
			    .image(productUpdateRequestDto.getImage())
			    .productStock(productUpdateRequestDto.getProductStock())
			    .safetyStock(productUpdateRequestDto.getSafetyStock())
			    .leadTime(productUpdateRequestDto.getLeadTime())
			    .updated_at(LocalDateTime.now())
			    .build();
	
		Product updatedProduct = productDAO.updateProduct(product);
	
		ProductUpdateResponseDto productUpdateResponseDto = ProductUpdateResponseDto.builder()
		        .productCode(updatedProduct.getProductCode())
				.name(updatedProduct.getName())
		        .productStock(updatedProduct.getProductStock())
		        .image(updatedProduct.getImage())
		        .safetyStock(updatedProduct.getSafetyStock())
		        .leadTime(updatedProduct.getLeadTime())
		        .updated_at(updatedProduct.getUpdated_at())
		        .build();

		return productUpdateResponseDto;
	}
	
	
	// 상품 삭제
	@Override
	public void deleteProduct(String productCode) throws Exception {
		productDAO.deleteProduct(productCode);
		
	}

	// 상품 검색 (상품 코드 or 이름) 
	@Override
	public List<ProductSearchCodeOrNameResponseDto> searchProductCodeOrName(String searchKeyword) {

		List<Product> searchProductList = productDAO.findByProductCodeContainingOrNameContaining(searchKeyword);
		
		List<ProductSearchCodeOrNameResponseDto> productSearchCodeOrNameResponseDtoList = searchProductList.stream()
				 .map(product -> ProductSearchCodeOrNameResponseDto.builder()
			                .productCode(product.getProductCode())
			                .safetyStock(product.getSafetyStock())
			                .name(product.getName())
			                .image(product.getImage())
			                .productStock(product.getProductStock())
			                .leadTime(product.getLeadTime())
			                .create_at(product.getCreate_at())
			                .build())
			     .collect(Collectors.toList());
		
		
		return productSearchCodeOrNameResponseDtoList;
	}
	
	// 상품 코드로 상품 검색 
	@Override
	public List<ProductSearchCodeOrNameResponseDto> searchProductCode(String searchKeyword) {
		List<Product> searchProductList = productDAO.findByProductCodeContaining(searchKeyword);
		
		List<ProductSearchCodeOrNameResponseDto> productSearchCodeOrNameResponseDtoList = searchProductList.stream()
				 .map(product -> ProductSearchCodeOrNameResponseDto.builder()
			                .productCode(product.getProductCode())
			                .safetyStock(product.getSafetyStock())
			                .name(product.getName())
			                .image(product.getImage())
			                .productStock(product.getProductStock())
			                .leadTime(product.getLeadTime())
			                .create_at(product.getCreate_at())
			                .build())
			     .collect(Collectors.toList());
		
		
		return productSearchCodeOrNameResponseDtoList;

	}

	// 상품 이름으로 상품 검색 
	@Override
	public List<ProductSearchCodeOrNameResponseDto> searchName(String searchKeyword) {
		List<Product> searchProductList = productDAO.findByNameContaining(searchKeyword);
		
		List<ProductSearchCodeOrNameResponseDto> productSearchCodeOrNameResponseDtoList = searchProductList.stream()
				 .map(product -> ProductSearchCodeOrNameResponseDto.builder()
			                .productCode(product.getProductCode())
			                .safetyStock(product.getSafetyStock())
			                .name(product.getName())
			                .image(product.getImage())
			                .productStock(product.getProductStock())
			                .leadTime(product.getLeadTime())
			                .create_at(product.getCreate_at())
			                .build())
			     .collect(Collectors.toList());
		
		
		return productSearchCodeOrNameResponseDtoList;
		
	}
	
	
}
