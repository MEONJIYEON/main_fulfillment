package com.ot.main.productmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ot.main.productmanagement.data.dao.ProductManagementDAO;
import com.ot.main.productmanagement.data.dto.MainToShopDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCompareResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCreateResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectListResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectOneResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementUpdateResponseDTO;
import com.ot.main.productmanagement.data.entity.ProductManagement;
import com.ot.main.productmanagement.service.ProductManagementService;


@Service
public class ProductManagementServiceImpl implements ProductManagementService {

	private ProductManagementDAO productManagementDAO;

	@Autowired
	public ProductManagementServiceImpl(ProductManagementDAO productManagementDAO) {
		this.productManagementDAO = productManagementDAO;
	}

    //create
	@Override
	public ProductManagementCreateResponseDTO createStock(String productCode) {

		ProductManagement productManagement = new ProductManagement();
		
		productManagement.setProductCode(productCode);


		ProductManagement createStock = productManagementDAO.createStock(productManagement);
	
		ProductManagementCreateResponseDTO result = new ProductManagementCreateResponseDTO();
		
		result.setId(createStock.getId());
		result.setLeadTime(createStock.getLeadTime());
		result.setName(createStock.getName());
		result.setProductCode(createStock.getProductCode());
		result.setProductStock(createStock.getProductStock());
		result.setSafetyStock(createStock.getSafetyStock());
		
		
		
		return result;
	}
	
	//update
	@Override
	public ProductManagementUpdateResponseDTO modifyInStock(String productCode, boolean InStatus, Integer InStock) {
		
		ProductManagement updateOutStock = productManagementDAO.modifyInStock(productCode, InStatus, InStock);
		
		ProductManagementUpdateResponseDTO result = new ProductManagementUpdateResponseDTO();
		
		result.setId(updateOutStock.getId());
		result.setLeadTime(updateOutStock.getLeadTime());
		result.setName(updateOutStock.getName());
		result.setProductCode(updateOutStock.getProductCode());
		result.setProductStock(updateOutStock.getProductStock());
		result.setSafetyStock(updateOutStock.getSafetyStock());
		
		return result;
	}
	
	
	//update
		@Override
		public ProductManagementUpdateResponseDTO modifyOutStock(String productCode, boolean OutStatus, Integer OutStock) {
			
			ProductManagement updateOutStock = productManagementDAO.modifyOutStock(productCode, OutStatus, OutStock);
			
			ProductManagementUpdateResponseDTO result = new ProductManagementUpdateResponseDTO();
			
			result.setId(updateOutStock.getId());
			result.setLeadTime(updateOutStock.getLeadTime());
			result.setName(updateOutStock.getName());
			result.setProductCode(updateOutStock.getProductCode());
			result.setProductStock(updateOutStock.getProductStock());
			result.setSafetyStock(updateOutStock.getSafetyStock());
			
			return result;
		}
	
	
	//selectStockDetail
	@Override
	public ProductManagementSelectOneResponseDTO selectStockDetail(Long id) {
		ProductManagement selectOneStock = productManagementDAO.selectOneStock(id);
		
		ProductManagementSelectOneResponseDTO result = new ProductManagementSelectOneResponseDTO();
		
		result.setId(selectOneStock.getId());
		result.setLeadTime(selectOneStock.getLeadTime());
		result.setName(selectOneStock.getName());
		result.setProductCode(selectOneStock.getProductCode());
		result.setProductStock(selectOneStock.getProductStock());
		result.setSafetyStock(selectOneStock.getSafetyStock());
		
		return result;
	}

	@Override
	public List<ProductManagementSelectListResponseDTO> selectStockList( ) {

		List<ProductManagement> findStockList = productManagementDAO.selectStockList();
		
		List<ProductManagementSelectListResponseDTO> stockList = findStockList.stream()
				.map(stock -> new ProductManagementSelectListResponseDTO(
					stock.getId(),
                    stock.getProductCode(),
                    stock.getLeadTime(),
                    stock.getName(),
                    stock.getProductStock(),
                    stock.getSafetyStock()))
			.collect(Collectors.toList());
				
		
		return stockList;
	}

	@Override
	public ProductManagementCompareResponseDTO compareStockAndSafetyStock(String productCode) {
	
		ProductManagement compareStock = productManagementDAO.compareStockAndSafetyStock(productCode);
		
		return null;
	}

	
	@Override
	public ResponseEntity<MainToShopDTO> mainToShop(MainToShopDTO mainToShopDTO) {
		WebClient webClient = WebClient.builder()
	            .baseUrl("http://localhost:9000")
	            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	            .build();

		System.out.println(mainToShopDTO);
	    return webClient.post()
	            .uri("/api/v1/shop-fulfillment/mainToShop")
	            .bodyValue(mainToShopDTO)
	            .retrieve()
	            .toEntity(MainToShopDTO.class)
	            .block();
	}

		

}
