package com.ot.main.productmanagement.service;

import java.util.List;

import com.ot.main.productmanagement.data.dto.ProductManagementResponseDTO;
import com.ot.main.productmanagement.data.entity.ProductManagement;

public interface ProductManagementService{

	//LOOK UP STOCK
	public List<ProductManagementResponseDTO> lookUpStock(ProductManagementResponseDTO productManagementResponseDTO);
	
	//LOOK UP STOCK DETAIL
	public ProductManagementResponseDTO lookUpStockDetail(Long id);
	
	//MODIFY STOCK
	public ProductManagementResponseDTO modifyStock(ProductManagementResponseDTO productManagementResponseDTO);
	
	//setting Orgin entity
	public List<ProductManagement> lookUpEntity();
	
	//CALCULATE SAFETYSTOCK
	public void calculateSafetyStock();
}
